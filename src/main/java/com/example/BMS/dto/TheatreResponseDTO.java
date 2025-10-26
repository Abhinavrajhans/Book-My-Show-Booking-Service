package com.example.BMS.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreResponseDTO {

    private Long id;
    private String name;
    private String address;
}
