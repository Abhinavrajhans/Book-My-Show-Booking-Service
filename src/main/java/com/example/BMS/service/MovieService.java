package com.example.BMS.service;

import com.example.BMS.models.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface MovieService {
    public List<Movie> findAllMovies();
    public Optional<Movie> findMovieById(Long id);
}
