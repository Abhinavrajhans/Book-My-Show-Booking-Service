package com.example.BMS.service;

import com.example.BMS.dto.MovieRequestDTO;
import com.example.BMS.dto.MovieResponseDTO;
import com.example.BMS.dto.ShowSeatRequestDTO;
import com.example.BMS.dto.ShowSeatResponseDTO;
import com.example.BMS.models.Movie;
import com.example.BMS.models.ShowSeat;

import java.util.List;

public interface ShowSeatService {

    public ShowSeatResponseDTO createShowSeat(ShowSeatRequestDTO showSeatRequestDTO);
    public List<ShowSeatResponseDTO> findAllShowSeats();
    public ShowSeatResponseDTO findShowSeatById(Long id);
    public ShowSeat findShowSeatEntityById(Long id);
}
