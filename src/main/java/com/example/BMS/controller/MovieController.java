package com.example.BMS.controller;

import com.example.BMS.dto.MovieRequestDTO;
import com.example.BMS.dto.MovieResponseDTO;
import com.example.BMS.models.Movie;
import com.example.BMS.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieResponseDTO> createMovie(@Valid @RequestBody MovieRequestDTO movieRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.createMovie(movieRequestDTO));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MovieResponseDTO> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.findMovieById(id));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponseDTO>>  getMovies() {
        return ResponseEntity.ok(movieService.findAllMovies());
    }
}
