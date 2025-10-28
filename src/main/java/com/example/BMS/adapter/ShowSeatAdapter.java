package com.example.BMS.adapter;

import com.example.BMS.dto.ShowSeatRequestDTO;
import com.example.BMS.dto.ShowSeatResponseDTO;
import com.example.BMS.models.Seat;
import com.example.BMS.models.Show;
import com.example.BMS.models.ShowSeat;
import com.example.BMS.models.Ticket;

public class ShowSeatAdapter {

    public static ShowSeat toEntity(ShowSeatRequestDTO dto, Seat seat, Show show)  {
        return ShowSeat.builder()
                .show(show)
                .seat(seat)
                .ticket(null)
                .status(dto.getStatus())
                .build();
    }

    public static ShowSeatResponseDTO toDTO(ShowSeat entity) {
        return ShowSeatResponseDTO.builder()
                .id(entity.getId())
                .status(entity.getStatus())
                .build();
    }
}
