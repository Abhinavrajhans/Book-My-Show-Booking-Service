package com.example.BMS.service.impl;

import com.example.BMS.adapter.ShowAdapter;
import com.example.BMS.dto.ShowRequestDTO;
import com.example.BMS.dto.ShowResponseDTO;
import com.example.BMS.models.Auditorium;
import com.example.BMS.models.Movie;
import com.example.BMS.models.Show;
import com.example.BMS.repository.ShowRepository;
import com.example.BMS.service.AuditoriumService;
import com.example.BMS.service.MovieService;
import com.example.BMS.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowServiceImpl implements ShowService {

    private final ShowRepository showRepository;
    private final MovieService movieService;
    private final AuditoriumService auditoriumService;

    @Override
    public ShowResponseDTO createShow(ShowRequestDTO showRequestDTO) {
        Movie movie = movieService.getMovieEntityById(showRequestDTO.getMovieId());
        Auditorium auditorium = auditoriumService.findAuditoriumEntityById(showRequestDTO.getAuditoriumId());
        return ShowAdapter.toDTO(showRepository.save(ShowAdapter.toEntity(showRequestDTO,movie,auditorium)));
    }

    @Override
    public ShowResponseDTO findShowById(Long showId) {
        Show show=showRepository.findById(showId).orElseThrow(()->new RuntimeException("Show not found"));
        return ShowAdapter.toDTO(show);
    }

    @Override
    public List<ShowResponseDTO> findAllShow() {
        return showRepository.findAll().stream().map(ShowAdapter::toDTO).collect(Collectors.toList());
    }

    @Override
    public Show findShowEntityById(Long ShowId) {
        return showRepository.findById(ShowId).orElseThrow(()->new RuntimeException("Show not found"));
    }


}

