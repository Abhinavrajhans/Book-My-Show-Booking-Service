package com.example.BMS.service.impl;


import com.example.BMS.adapter.CityAdapter;
import com.example.BMS.dto.CityRequestDTO;
import com.example.BMS.dto.CityResponseDTO;
import com.example.BMS.models.City;
import com.example.BMS.repository.CityRepository;
import com.example.BMS.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public CityResponseDTO createCity(CityRequestDTO cityRequestDTO) {
        return CityAdapter.toDto(cityRepository.save(CityAdapter.toEntity(cityRequestDTO)));
    }

    @Override
    public CityResponseDTO findCityById(Long id) {
        City city=cityRepository.findById(id).orElseThrow(()-> new RuntimeException("City Not Found"));
        return CityAdapter.toDto(city);
    }

    @Override
    public List<CityResponseDTO> findAllCities() {
        return cityRepository.findAll().stream().map(CityAdapter::toDto).collect(Collectors.toList());
    }

    @Override
    public City findCityEntityById(Long id){
        return cityRepository.findById(id).orElseThrow(()-> new RuntimeException("City Not Found"));
    }


}
