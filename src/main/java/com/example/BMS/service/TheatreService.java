package com.example.BMS.service;

import com.example.BMS.dto.TheatreRequestDTO;
import com.example.BMS.dto.TheatreResponseDTO;
import com.example.BMS.models.Theatre;

import java.util.List;

public interface TheatreService {

    TheatreResponseDTO createTheatre(TheatreRequestDTO theatreRequestDTO);
    TheatreResponseDTO findTheatreById(Long id);
    Theatre findTheatreEntityById(Long id);
    List<TheatreResponseDTO> findAllTheatres();
}
