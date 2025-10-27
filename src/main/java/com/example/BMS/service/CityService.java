package com.example.BMS.service;


import com.example.BMS.dto.CityRequestDTO;
import com.example.BMS.dto.CityResponseDTO;
import com.example.BMS.models.City;

import java.util.List;

public interface CityService {

    CityResponseDTO createCity(CityRequestDTO cityRequestDTO);
    CityResponseDTO findCityById(Long id);
    List<CityResponseDTO> findAllCities();
    City findCityEntityById(Long id);
}
