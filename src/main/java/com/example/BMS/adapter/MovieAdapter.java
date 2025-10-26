package com.example.BMS.adapter;

import com.example.BMS.dto.MovieRequestDTO;
import com.example.BMS.dto.MovieResponseDTO;
import com.example.BMS.models.Movie;

public class MovieAdapter {

    public static Movie toEntity(MovieRequestDTO dto)
    {
        return Movie.builder()
                .name(dto.getName())
                .poster(dto.getPoster())
                .build();
    }

    public static MovieResponseDTO toDTO(Movie entity)
    {
        return MovieResponseDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .poster(entity.getPoster())
                .build();
    }
}
