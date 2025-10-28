package com.example.BMS.adapter;

import com.example.BMS.dto.BookingRequestDTO;
import com.example.BMS.dto.TicketRequestDTO;
import com.example.BMS.dto.TicketResponseDTO;
import com.example.BMS.dto.TicketWithSeatRequestDTO;
import com.example.BMS.models.*;

import java.util.List;

public class TicketAdapter {

    public static TicketWithSeatRequestDTO makeTicketWithSeatRequestDTO(int amount, BookingRequestDTO bookingRequestDTO, TicketStatus ticketStatus)
    {
        return TicketWithSeatRequestDTO .builder()
                .amount(amount)
                .userId(bookingRequestDTO.getUserId())
                .showId(bookingRequestDTO.getShowId())
                .seatIds(bookingRequestDTO.getShowSeatIds())
                .status(ticketStatus)
                .build();
    }
    public static Ticket toEntity(TicketRequestDTO  dto, User user, Show show) {
        return Ticket.builder()
                .amount(dto.getAmount())
                .user(user)
                .show(show)
                .status(dto.getStatus())
                .build();
    }

    public static Ticket toEntity(TicketWithSeatRequestDTO dto, User user,Show show,List<ShowSeat> showSeats) {
        return Ticket.builder()
                .amount(dto.getAmount())
                .user(user)
                .show(show)
                .status(dto.getStatus())
                .showSeat(showSeats)
                .build();
    }

    public static TicketResponseDTO toDTO(Ticket entity)
    {
        return TicketResponseDTO.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .status(entity.getStatus())
                .build();
    }


}
