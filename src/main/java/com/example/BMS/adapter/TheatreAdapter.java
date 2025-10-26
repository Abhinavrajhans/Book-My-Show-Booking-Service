package com.example.BMS.adapter;

import com.example.BMS.dto.TheatreRequestDTO;
import com.example.BMS.dto.TheatreResponseDTO;
import com.example.BMS.models.Auditorium;
import com.example.BMS.models.City;
import com.example.BMS.models.Theatre;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class TheatreAdapter {

    public static Theatre toEntity(TheatreRequestDTO dto, City city)
    {
        return Theatre.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .city(city)
                .build();
    }

    public static TheatreResponseDTO toDTO(Theatre entity)
    {
        return TheatreResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .address(entity.getAddress())
                .build();
    }
}
