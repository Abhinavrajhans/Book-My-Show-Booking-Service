package com.example.BMS.controller;

import com.example.BMS.dto.BookingRequestDTO;
import com.example.BMS.models.Ticket;
import com.example.BMS.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/block")
    public boolean blockSeats(@RequestBody BookingRequestDTO bookingRequestDTO) {
        return bookingService.blockSeats(bookingRequestDTO);
    }

    @DeleteMapping
    public void clearAllSetLocks(){
        bookingService.clearAllSeatLocks();
    }

    @PostMapping("/confirm")
    public Optional<Ticket> confirmBooking(@RequestBody BookingRequestDTO bookingRequestDTO) {
        return bookingService.bookTicket(bookingRequestDTO);

    }
}
