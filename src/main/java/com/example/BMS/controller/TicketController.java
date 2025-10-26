package com.example.BMS.controller;

import com.example.BMS.dto.TicketRequestDTO;
import com.example.BMS.dto.TicketResponseDTO;
import com.example.BMS.service.TicketService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<TicketResponseDTO> createTicket(@Valid @RequestBody TicketRequestDTO ticketRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.createTicket(ticketRequestDTO));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TicketResponseDTO> findTicketById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.findTicketById(id));
    }

    @GetMapping
    public ResponseEntity<List<TicketResponseDTO>> findAllTickets() {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.findAllTickets());
    }

}
