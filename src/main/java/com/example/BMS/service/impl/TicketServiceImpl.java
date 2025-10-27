package com.example.BMS.service.impl;

import com.example.BMS.adapter.TicketAdapter;
import com.example.BMS.dto.TicketRequestDTO;
import com.example.BMS.dto.TicketResponseDTO;
import com.example.BMS.models.Show;
import com.example.BMS.models.Ticket;
import com.example.BMS.models.User;
import com.example.BMS.repository.TicketRepository;
import com.example.BMS.service.ShowService;
import com.example.BMS.service.TicketService;
import com.example.BMS.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final UserService userService;
    private final ShowService showService;

    public TicketResponseDTO createTicket(TicketRequestDTO ticketRequestDTO) {
        User user = userService.findUserEntityById(ticketRequestDTO.getUserId());
        Show show = showService.findShowEntityById(ticketRequestDTO.getShowId());
        return TicketAdapter.toDTO(ticketRepository.save(TicketAdapter.toEntity(ticketRequestDTO,user,show)));
    }


    public TicketResponseDTO findTicketById(Long id) {
        Ticket ticket=ticketRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        return TicketAdapter.toDTO(ticket);
    }

    public Ticket findTicketEntityById(Long id) {
        return  ticketRepository.findById(id).orElseThrow(()-> new RuntimeException("Entity not found"));
    }

    public List<TicketResponseDTO> findAllTickets() {
        return ticketRepository.findAll().stream().map(TicketAdapter::toDTO).collect(Collectors.toList());
    }


}
