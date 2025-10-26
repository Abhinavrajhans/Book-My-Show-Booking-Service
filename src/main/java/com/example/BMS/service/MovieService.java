package com.example.BMS.service;

import com.example.BMS.dto.MovieRequestDTO;
import com.example.BMS.dto.MovieResponseDTO;
import com.example.BMS.models.Movie;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


public interface MovieService {
    public MovieResponseDTO createMovie(MovieRequestDTO movieRequestDTO);
    public List<MovieResponseDTO> findAllMovies();
    public MovieResponseDTO findMovieById(Long id);
    public Movie getMovieEntityById(Long id);
}
