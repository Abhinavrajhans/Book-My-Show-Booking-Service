package com.example.BMS.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowResponseDTO {

    private Long id;
    private Date startTime;
    private Date endTime;
}
