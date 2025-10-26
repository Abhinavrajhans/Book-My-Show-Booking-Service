package com.example.BMS.adapter;

import com.example.BMS.dto.UserRequestDTO;
import com.example.BMS.dto.UserResponseDTO;
import com.example.BMS.models.User;

public class UserAdapter {

    public static User toEntity(UserRequestDTO dto)
    {
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .build();
    }

    public static UserResponseDTO toDTO(User user)
    {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
