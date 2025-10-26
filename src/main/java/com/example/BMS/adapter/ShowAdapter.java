package com.example.BMS.adapter;

import com.example.BMS.dto.ShowRequestDTO;
import com.example.BMS.dto.ShowResponseDTO;
import com.example.BMS.models.Auditorium;
import com.example.BMS.models.Movie;
import com.example.BMS.models.Show;

public class ShowAdapter {

    public static Show toEntity(ShowRequestDTO dto, Movie movie, Auditorium auditorium) {
        return Show.builder()
                .movie(movie)
                .auditorium(auditorium)
                .startTime(dto.getStartTime())
                .endTime(dto.getEndTime())
                .build();

    }

    public static ShowResponseDTO toDTO(Show entity) {
        return ShowResponseDTO.builder()
                .id(entity.getId())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .build();

    }
}
