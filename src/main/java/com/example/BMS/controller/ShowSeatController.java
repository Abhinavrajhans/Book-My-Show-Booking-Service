package com.example.BMS.controller;


import com.example.BMS.dto.ShowRequestDTO;
import com.example.BMS.dto.ShowResponseDTO;
import com.example.BMS.dto.ShowSeatRequestDTO;
import com.example.BMS.dto.ShowSeatResponseDTO;
import com.example.BMS.service.ShowSeatService;
import com.example.BMS.service.ShowService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/showseat")
@RequiredArgsConstructor
public class ShowSeatController {

    private final ShowSeatService showSeatService;

    @PostMapping
    public ResponseEntity<ShowSeatResponseDTO> createShowSeat(@Valid @RequestBody ShowSeatRequestDTO showSeatRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(showSeatService.createShowSeat(showSeatRequestDTO));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ShowSeatResponseDTO> findShowSeatById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(showSeatService.findShowSeatById(id));
    }

    @GetMapping
    public ResponseEntity<List<ShowSeatResponseDTO>> findAllShowSeats() {
        return ResponseEntity.status(HttpStatus.OK).body(showSeatService.findAllShowSeats());
    }

}
