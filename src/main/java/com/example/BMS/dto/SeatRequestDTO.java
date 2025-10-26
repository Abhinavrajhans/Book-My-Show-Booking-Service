package com.example.BMS.dto;

import com.example.BMS.models.Auditorium;
import com.example.BMS.models.SeatType;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatRequestDTO {
    @NotNull(message="Seat Number Is Required")
    private String seatNumber;

    @NotNull(message="Row Value is Required")
    private int rowValue;

    @NotNull(message="Column Value is Required")
    private int columnValue;

    @NotNull(message="Seat Type is Required")
    private SeatType seatType;

    @NotNull(message="Auditorium is required")
    private Long auditoriumId;  // Changed to Long
}
