package com.example.BMS.dto;

import com.example.BMS.models.SeatType;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatResponseDTO {

    private long id;
    private String seatNumber;
    private int rowValue;
    private int columnValue;
    private SeatType seatType;
}
