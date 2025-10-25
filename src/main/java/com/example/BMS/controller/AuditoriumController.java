package com.example.BMS.controller;

import com.example.BMS.dto.AuditoriumRequestDTO;
import com.example.BMS.dto.AuditoriumResponseDTO;
import com.example.BMS.models.Auditorium;
import com.example.BMS.service.AuditoriumService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/auditorium")
@RequiredArgsConstructor
public class AuditoriumController {

    private final AuditoriumService auditoriumService;

    @PostMapping
    public ResponseEntity<AuditoriumResponseDTO> createAuditorium(@Valid @RequestBody AuditoriumRequestDTO auditoriumRequestDTO) {
        AuditoriumResponseDTO auditoriumResponseDTO = auditoriumService.createAuditorium(auditoriumRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(auditoriumResponseDTO);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<AuditoriumResponseDTO> getAuditoriumById(@PathVariable Long id) {
        return ResponseEntity.ok(auditoriumService.getAuditoriumById(id));
    }

    @GetMapping
    public ResponseEntity<List<AuditoriumResponseDTO>> getAllAuditoriums() {
        List<AuditoriumResponseDTO> auditoriums = auditoriumService.getAllAuditorium();
        return ResponseEntity.ok(auditoriums);
    }

}
