package com.example.BMS.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieRequestDTO {

    @NotBlank(message="movie name is required")
    @Size(min=2,max=100, message="The name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message="poster is required")
    private String poster;
}
