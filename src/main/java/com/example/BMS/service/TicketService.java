package com.example.BMS.service;

import com.example.BMS.dto.*;
import com.example.BMS.models.Ticket;
import com.example.BMS.models.User;

import java.util.List;

public interface TicketService {

    TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO);
    Ticket createTicketAndReturnTicket(TicketRequestDTO ticketRequestDTO);
    Ticket createdTicketWithSeats(TicketWithSeatRequestDTO ticketRequestDTO);
    TicketResponseDTO findTicketById(Long id);
    Ticket findTicketEntityById(Long id);
    List<TicketResponseDTO> findAllTickets();
}
