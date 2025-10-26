package com.example.BMS.controller;

import com.example.BMS.dto.TheatreRequestDTO;
import com.example.BMS.dto.TheatreResponseDTO;
import com.example.BMS.service.TheatreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/theatre")
@RequiredArgsConstructor
public class TheatreController {

    public final TheatreService theatreService;

    @PostMapping
    public ResponseEntity<TheatreResponseDTO> createTheatre(@Valid @RequestBody TheatreRequestDTO theatre) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(theatreService.createTheatre(theatre));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TheatreResponseDTO> getTheatreById(@PathVariable Long id) {
        return  ResponseEntity.status(HttpStatus.OK).body(theatreService.findTheatreById(id));
    }

    @GetMapping
    public ResponseEntity<List<TheatreResponseDTO>> getAllTheatres() {
        return ResponseEntity.status(HttpStatus.OK).body(theatreService.findAllTheatres());
    }


}
