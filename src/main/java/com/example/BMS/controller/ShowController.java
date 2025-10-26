package com.example.BMS.controller;


import com.example.BMS.dto.ShowRequestDTO;
import com.example.BMS.dto.ShowResponseDTO;
import com.example.BMS.service.ShowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/show")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @PostMapping
    public ResponseEntity<ShowResponseDTO> createShow(@Valid @RequestBody ShowRequestDTO showRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(showService.createShow(showRequestDTO));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ShowResponseDTO> findshowById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(showService.findShowById(id));
    }

    @GetMapping
    public ResponseEntity<List<ShowResponseDTO>> findAllshows() {
        return ResponseEntity.status(HttpStatus.OK).body(showService.findAllShow());
    }

}
