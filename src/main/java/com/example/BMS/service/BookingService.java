package com.example.BMS.service;

import com.example.BMS.dto.BookingRequestDTO;
import com.example.BMS.models.Ticket;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    boolean blockSeats(BookingRequestDTO bookingRequestDTO);

    Optional<Ticket> bookTicket(BookingRequestDTO bookingRequestDTO);

    void clearAllSeatLocks();
}
