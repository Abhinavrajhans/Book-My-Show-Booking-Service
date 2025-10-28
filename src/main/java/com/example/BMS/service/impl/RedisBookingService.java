package com.example.BMS.service.impl;

import com.example.BMS.adapter.TicketAdapter;
import com.example.BMS.dto.BookingRequestDTO;
import com.example.BMS.models.ShowSeat;
import com.example.BMS.models.ShowSeatStatus;
import com.example.BMS.models.Ticket;
import com.example.BMS.models.TicketStatus;
import com.example.BMS.repository.ShowSeatRepository;
import com.example.BMS.service.BookingService;
import com.example.BMS.service.CacheService;
import com.example.BMS.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RedisBookingService implements BookingService {

    private final CacheService cacheService;
    private final ShowSeatRepository showSeatRepository;
    private final TicketService ticketService;

    @Override
    public boolean blockSeats(BookingRequestDTO bookingRequestDTO) {

        System.out.println("Printing Cache Before logic");
        cacheService.getAllKeysAndValues();
        // 1. we will first of all check if the seats are available or not
        // a. check if the seats are not booked already
        List<ShowSeat> showSeats = showSeatRepository.
                findAllByShowIdAndSeatIdIn(bookingRequestDTO.getShowId(),bookingRequestDTO.getShowSeatIds());

        System.out.println("Printing Showseats");
        showSeats.forEach(showSeat -> System.out.println(showSeat.getId()+" --> "+showSeat.getStatus()));

        for(ShowSeat seat:showSeats){
            if(seat.getStatus()== ShowSeatStatus.BOOKED)return false;
        }
        // b. check if the seats are not locked already
        for(ShowSeat seat:showSeats){
            String status =(String) cacheService.get("seatId-"+seat.getId()+"-userId-"+bookingRequestDTO.getUserId());
            if(status!=null)return false;

        }

        // 2. if all the seats are available then we will block the seats in redis - seatId - userId
        for(ShowSeat seat:showSeats){
           cacheService.set("seatId-"+seat.getId()+"-userId-"+bookingRequestDTO.getUserId(),"LOCKED");
        }

        System.out.println("Printing Cache After Logic.");
        cacheService.getAllKeysAndValues();
        return true;
    }

    @Override
    @Transactional
    public Optional<Ticket> bookTicket(BookingRequestDTO bookingRequestDTO) {
        // 1.in redis check if the user has lock for all the seats that they are trying to book

        for(Long showSeatId:bookingRequestDTO.getShowSeatIds()){
            String status = (String) cacheService.get("seatId-"+showSeatId+"-userId-"+bookingRequestDTO.getUserId());
            System.out.println("status:"+status + "seatId-"+showSeatId+"-userId-"+bookingRequestDTO.getUserId() );
            if(status!=null)return Optional.empty();
        }
        System.out.println("All Seats Available");

        //Create a new Ticket
        Ticket ticket = this.createTicketAndBookSeats(bookingRequestDTO);
        showSeatRepository.bookShowSeatsBulk(bookingRequestDTO.getShowSeatIds(), ticket);

        // now we can remove here from redis , but i will be automatically removed as it has ttl.


        // 2. go to all the rows of showseats and update the status to booked and update Ticket id in one query
        // it will be a bulk update , we will not write n+1 queries


        System.out.println("ticket created");
        return Optional.of(ticket);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    protected Ticket createTicketAndBookSeats(BookingRequestDTO bookingRequestDTO) {
            return ticketService.createdTicketWithSeats(
                    TicketAdapter.makeTicketWithSeatRequestDTO(100,bookingRequestDTO,TicketStatus.BOOKED)
            );
    }



    @Override
    public void clearAllSeatLocks() {
        cacheService.deleteAll();
    }
}
