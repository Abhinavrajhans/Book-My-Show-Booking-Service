package com.example.BMS.dto;


import com.example.BMS.models.Seat;
import com.example.BMS.models.Show;
import com.example.BMS.models.Theatre;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuditoriumRequestDTO {


    @NotBlank(message="name is required")
    @Size(min=2,max=100,message="The name must be between 2 and 100 characters")
    private String name;

    @NotNull(message="capacity is required")
    private int capacity;

    @NotNull(message="Theatre is required")
    private Long theatreId;

}
