package com.example.BMS.service;

import com.example.BMS.dto.TicketRequestDTO;
import com.example.BMS.dto.TicketResponseDTO;
import com.example.BMS.dto.UserRequestDTO;
import com.example.BMS.dto.UserResponseDTO;
import com.example.BMS.models.Ticket;
import com.example.BMS.models.User;

import java.util.List;

public interface TicketService {

    TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO);
    TicketResponseDTO findTicketById(Long id);
    Ticket findTicketEntityById(Long id);
    List<TicketResponseDTO> findAllTickets();
}
