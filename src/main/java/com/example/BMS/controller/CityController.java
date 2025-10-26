package com.example.BMS.controller;

import com.example.BMS.dto.CityRequestDTO;
import com.example.BMS.dto.CityResponseDTO;
import com.example.BMS.service.CityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @PostMapping
    public ResponseEntity<CityResponseDTO> createCity(@Valid @RequestBody CityRequestDTO cityRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(cityService.addCity(cityRequestDTO));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CityResponseDTO> findCityById(@PathVariable Long id){
        return ResponseEntity.ok(cityService.findCityById(id));
    }

    @GetMapping
    public ResponseEntity<List<CityResponseDTO>> findAllCity(){
        return ResponseEntity.ok(cityService.findAllCities());
    }
}
