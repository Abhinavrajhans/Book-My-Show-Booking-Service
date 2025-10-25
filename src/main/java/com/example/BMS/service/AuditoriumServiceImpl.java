package com.example.BMS.service;

import com.example.BMS.adapter.AuditoriumAdapter;
import com.example.BMS.dto.AuditoriumRequestDTO;
import com.example.BMS.dto.AuditoriumResponseDTO;
import com.example.BMS.models.Auditorium;
import com.example.BMS.repository.AuditoriumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuditoriumServiceImpl implements AuditoriumService {

    private final AuditoriumRepository auditoriumRepository;

    @Override
    public AuditoriumResponseDTO createAuditorium(AuditoriumRequestDTO dto) {
        return AuditoriumAdapter.toDTO(auditoriumRepository.save(AuditoriumAdapter.toEntity(dto)));
    }

    @Override
    public AuditoriumResponseDTO getAuditoriumById(Long id) {
        Auditorium auditorium = auditoriumRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Auditorium not found with id: " + id));
        return AuditoriumAdapter.toDTO(auditorium);
    }

    @Override
    public List<AuditoriumResponseDTO> getAllAuditorium() {
        return auditoriumRepository.findAll()
                .stream()
                .map(AuditoriumAdapter::toDTO)
                .collect(Collectors.toList());
    }


}
