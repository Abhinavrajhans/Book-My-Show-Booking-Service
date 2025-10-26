package com.example.BMS.service;

import com.example.BMS.dto.TheatreRequestDTO;
import com.example.BMS.dto.TheatreResponseDTO;
import com.example.BMS.dto.UserRequestDTO;
import com.example.BMS.dto.UserResponseDTO;
import com.example.BMS.models.Theatre;
import com.example.BMS.models.User;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    UserResponseDTO findUserById(Long id);
    User findUserEntityById(Long id);
    List<UserResponseDTO> findAllUsers();
}
