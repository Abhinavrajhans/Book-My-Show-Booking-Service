package com.example.BMS.adapter;

import com.example.BMS.dto.AuditoriumRequestDTO;
import com.example.BMS.dto.AuditoriumResponseDTO;
import com.example.BMS.models.Auditorium;

public class AuditoriumAdapter {

    public static Auditorium toEntity(AuditoriumRequestDTO dto) {
        return Auditorium.builder()
                .name(dto.getName())
                .capacity(dto.getCapacity())
                .build();
    }

    public static AuditoriumResponseDTO toDTO(Auditorium entity){
        return AuditoriumResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .capacity(entity.getCapacity())
                .build();
    }
}
