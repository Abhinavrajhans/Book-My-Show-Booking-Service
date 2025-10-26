package com.example.BMS.service.impl;

import com.example.BMS.adapter.TheatreAdapter;
import com.example.BMS.dto.TheatreRequestDTO;
import com.example.BMS.dto.TheatreResponseDTO;
import com.example.BMS.models.City;
import com.example.BMS.models.Theatre;
import com.example.BMS.repository.TheatreRepository;
import com.example.BMS.service.CityService;
import com.example.BMS.service.TheatreService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TheatreServiceImpl implements TheatreService {

    private final TheatreRepository theatreRepository;
    private final CityService cityService;

    public TheatreResponseDTO createTheatre(TheatreRequestDTO theatreRequestDTO) {
        City city = cityService.findCityEntityById(theatreRequestDTO.getCityId());
        return TheatreAdapter.toDTO(theatreRepository.save(TheatreAdapter.toEntity(theatreRequestDTO, city)));
    }

    public TheatreResponseDTO findTheatreById(Long id) {
        Theatre theatre=theatreRepository.findById(id).orElseThrow(()-> new RuntimeException("Entity not found"));
        return TheatreAdapter.toDTO(theatre);
    }

    public Theatre findTheatreEntityById(Long id) {
        return  theatreRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Entity not found"));
    }


    public List<TheatreResponseDTO> findAllTheatres() {
        return theatreRepository.findAll()
                .stream().map(TheatreAdapter::toDTO).collect(Collectors.toList());
    }


}
