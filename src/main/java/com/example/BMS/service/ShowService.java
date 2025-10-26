package com.example.BMS.service;

import com.example.BMS.dto.ShowRequestDTO;
import com.example.BMS.dto.ShowResponseDTO;
import com.example.BMS.models.Show;

import java.util.List;

public interface ShowService {

    ShowResponseDTO createShow(ShowRequestDTO showRequestDTO);
    ShowResponseDTO findShowById(Long showId);
    List<ShowResponseDTO> findAllShow();
    Show findShowEntityById(Long ShowId);
}
