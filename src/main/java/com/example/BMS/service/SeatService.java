package com.example.BMS.service;

import com.example.BMS.dto.SeatRequestDTO;
import com.example.BMS.dto.SeatResponseDTO;
import com.example.BMS.models.Seat;

import java.util.List;

public interface SeatService {
    SeatResponseDTO createSeat(SeatRequestDTO seatRequestDTO);
    SeatResponseDTO findSeatById(Long id);
    List<SeatResponseDTO> findAllSeats();
    Seat findSeatEntityById(Long id);
}
