package com.example.BMS.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuditoriumResponseDTO {

    private Long id;
    private String name;
    private int capacity;
}
