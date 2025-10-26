package com.example.BMS.service.impl;

import com.example.BMS.adapter.UserAdapter;
import com.example.BMS.dto.UserRequestDTO;
import com.example.BMS.dto.UserResponseDTO;
import com.example.BMS.models.User;
import com.example.BMS.repository.UserRepository;
import com.example.BMS.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
       return UserAdapter.toDTO(userRepository.save(UserAdapter.toEntity(userRequestDTO)));
    }

    public UserResponseDTO findUserById(Long id) {
        User user=userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        return UserAdapter.toDTO(user);
    }

    public User findUserEntityById(Long id) {
        return  userRepository.findById(id).orElseThrow(()-> new RuntimeException("Entity not found"));
    }

    public List<UserResponseDTO> findAllUsers() {
        return userRepository.findAll().stream().map(UserAdapter::toDTO).collect(Collectors.toList());
    }


}
