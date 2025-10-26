package com.example.BMS.service.impl;

import com.example.BMS.adapter.SeatAdapter;
import com.example.BMS.dto.SeatRequestDTO;
import com.example.BMS.dto.SeatResponseDTO;
import com.example.BMS.models.Auditorium;
import com.example.BMS.models.Seat;
import com.example.BMS.repository.SeatRepository;
import com.example.BMS.service.AuditoriumService;
import com.example.BMS.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;
    private final AuditoriumService auditoriumService;

    @Override
    public SeatResponseDTO createSeat(SeatRequestDTO seatRequestDTO) {
        Auditorium auditorium = auditoriumService.findAuditoriumEntityById(seatRequestDTO.getAuditoriumId());
        return SeatAdapter.toDTO(seatRepository.save(SeatAdapter.toEntity(seatRequestDTO,auditorium)));
    }

    @Override
    public SeatResponseDTO findSeatById(Long id) {
        Seat seat=seatRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Seat not found"));
        return SeatAdapter.toDTO(seat);
    }

    @Override
    public List<SeatResponseDTO> findAllSeats() {
        return seatRepository.findAll().stream().map(SeatAdapter::toDTO).collect(Collectors.toList());
    }

    @Override
    public Seat findSeatEntityById(Long id) {
        return seatRepository.findById(id).orElseThrow(()-> new RuntimeException("Seat not found"));
    }
}
