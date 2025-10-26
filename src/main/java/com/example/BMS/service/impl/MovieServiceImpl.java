package com.example.BMS.service.impl;

import com.example.BMS.adapter.MovieAdapter;
import com.example.BMS.dto.MovieRequestDTO;
import com.example.BMS.dto.MovieResponseDTO;
import com.example.BMS.models.Movie;
import com.example.BMS.repository.MovieRepository;
import com.example.BMS.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieResponseDTO createMovie(MovieRequestDTO movieRequestDTO) {
        return MovieAdapter.toDTO(movieRepository.save(MovieAdapter.toEntity(movieRequestDTO)));
    }

    @Override
    public List<MovieResponseDTO> findAllMovies() {
        return movieRepository.findAll().stream().map(MovieAdapter::toDTO).collect(Collectors.toList());
    }

    @Override
    public MovieResponseDTO findMovieById(Long id) {
        Movie movie=movieRepository.findById(id).orElseThrow(()-> new RuntimeException("Movie not found"));
        return MovieAdapter.toDTO(movie);
    }

    @Override
    public Movie getMovieEntityById(Long id) {
        return movieRepository.findById(id).orElseThrow(()-> new RuntimeException("Movie not found"));
    }


}
