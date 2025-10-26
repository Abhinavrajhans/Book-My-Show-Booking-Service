package com.example.BMS.adapter;

import com.example.BMS.dto.TicketRequestDTO;
import com.example.BMS.dto.TicketResponseDTO;
import com.example.BMS.models.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class TicketAdapter {


    public static Ticket toEntity(TicketRequestDTO dto, User user,Show show) {
        return Ticket.builder()
                .amount(dto.getAmount())
                .user(user)
                .show(show)
                .status(dto.getStatus())
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
