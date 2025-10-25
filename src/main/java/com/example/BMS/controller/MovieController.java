package com.example.BMS.controller;

import com.example.BMS.models.Movie;
import com.example.BMS.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.findAllMovies();
    }

    @GetMapping("/id/{id}")
    public Movie getMovieById(@PathVariable Long id){
        return movieService.findMovieById(id).orElse(null);
    }
}
