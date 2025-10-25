package com.example.BMS.service;

import com.example.BMS.dto.AuditoriumRequestDTO;
import com.example.BMS.dto.AuditoriumResponseDTO;
import com.example.BMS.models.Auditorium;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AuditoriumService {

    AuditoriumResponseDTO createAuditorium(AuditoriumRequestDTO auditoriumRequestDTO);
    AuditoriumResponseDTO getAuditoriumById(Long id);
    List<AuditoriumResponseDTO> getAllAuditorium();
}
