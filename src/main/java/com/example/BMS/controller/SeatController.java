package com.example.BMS.controller;


import com.example.BMS.dto.SeatRequestDTO;
import com.example.BMS.dto.SeatResponseDTO;
import com.example.BMS.service.SeatService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/seat")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;

    @PostMapping
    public ResponseEntity<SeatResponseDTO> createSeat(@Valid @RequestBody SeatRequestDTO seatRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(seatService.createSeat(seatRequestDTO));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<SeatResponseDTO> findSeatById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(seatService.findSeatById(id));
    }

    @GetMapping
    public ResponseEntity<List<SeatResponseDTO>> findAllSeats() {
        return ResponseEntity.status(HttpStatus.OK).body(seatService.findAllSeats());
    }

}
