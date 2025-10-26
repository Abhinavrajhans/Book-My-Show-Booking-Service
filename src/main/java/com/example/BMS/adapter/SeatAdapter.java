package com.example.BMS.adapter;

import com.example.BMS.dto.SeatRequestDTO;
import com.example.BMS.dto.SeatResponseDTO;
import com.example.BMS.models.Auditorium;
import com.example.BMS.models.Seat;
import com.example.BMS.models.SeatType;

public class SeatAdapter {

    public static Seat toEntity(SeatRequestDTO dto, Auditorium auditorium) {
        return Seat.builder()
                .seatNumber(dto.getSeatNumber())
                .rowValue(dto.getRowValue())
                .columnValue(dto.getColumnValue())
                .auditorium(auditorium)
                .seatType(dto.getSeatType())
                .build();
    }

    public static SeatResponseDTO toDTO(Seat entity){


        return SeatResponseDTO.builder()
                .id(entity.getId())
                .seatNumber(entity.getSeatNumber())
                .rowValue(entity.getRowValue())
                .columnValue(entity.getColumnValue())
                .seatType(entity.getSeatType())
                .build();
    }
}

