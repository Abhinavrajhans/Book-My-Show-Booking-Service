package com.example.BMS.adapter;

import com.example.BMS.dto.CityRequestDTO;
import com.example.BMS.dto.CityResponseDTO;
import com.example.BMS.models.City;

public class CityAdapter {

    public static City toEntity(CityRequestDTO dto)
    {
        return City.builder()
                .name(dto.getName())
                .build();
    }

    public static CityResponseDTO toDto(City entity)
    {
        return CityResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
