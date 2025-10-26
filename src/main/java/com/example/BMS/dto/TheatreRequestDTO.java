package com.example.BMS.dto;

import com.example.BMS.models.Auditorium;
import com.example.BMS.models.City;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TheatreRequestDTO {


    @NotBlank(message="Name is required")
    @Size(min=1, max=50,message="Name must be between 1 and 50 characters")
    private String name;

    @NotBlank(message = "Address is required")
    @Size(min=5 ,max=1000 , message = "Address must be between 5 and 1000 characters")
    private String address;

    @NotNull(message="CityId is required")
    private Long cityId;
}
