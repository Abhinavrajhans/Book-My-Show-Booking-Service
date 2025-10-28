package com.example.BMS.service.impl;


import com.example.BMS.adapter.ShowSeatAdapter;
import com.example.BMS.dto.ShowSeatRequestDTO;
import com.example.BMS.dto.ShowSeatResponseDTO;
import com.example.BMS.models.Seat;
import com.example.BMS.models.Show;
import com.example.BMS.models.ShowSeat;
import com.example.BMS.repository.ShowSeatRepository;
import com.example.BMS.service.SeatService;
import com.example.BMS.service.ShowSeatService;
import com.example.BMS.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowSeatServiceImpl implements ShowSeatService {

    private final ShowSeatRepository showSeatRepository;
    private final SeatService seatService;
    private final ShowService showService;

    @Override
    public ShowSeatResponseDTO createShowSeat(ShowSeatRequestDTO showSeatRequestDTO) {
        Seat seat = seatService.findSeatEntityById(showSeatRequestDTO.getSeatId());
        Show show =  showService.findShowEntityById(showSeatRequestDTO.getShowId());
        return ShowSeatAdapter.toDTO(showSeatRepository.save(ShowSeatAdapter.toEntity(showSeatRequestDTO,seat,show)));
    }

    @Override
    public ShowSeatResponseDTO findShowSeatById(Long showSeatId) {
        ShowSeat showSeat=showSeatRepository.findById(showSeatId).orElseThrow(()->new RuntimeException("Show Seat not found"));
        return ShowSeatAdapter.toDTO(showSeat);
    }

    @Override
    public List<ShowSeatResponseDTO> findAllShowSeats() {
        return showSeatRepository.findAll().stream().map(ShowSeatAdapter::toDTO).collect(Collectors.toList());
    }

    @Override
    public ShowSeat findShowSeatEntityById(Long ShowSeatId) {
        return showSeatRepository.findById(ShowSeatId).orElseThrow(()->new RuntimeException("ShowSeat not found"));
    }


}

