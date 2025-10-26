package com.example.BMS.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditoriumResponseDTO {

    private Long id;
    private String name;
    private int capacity;
}
