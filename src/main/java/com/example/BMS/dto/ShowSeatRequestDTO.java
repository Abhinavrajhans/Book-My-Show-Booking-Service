package com.example.BMS.dto;

import com.example.BMS.models.ShowSeatStatus;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowSeatRequestDTO {

    @NotNull(message="show is required")
    private Long showId;

    @NotNull(message="seat is required")
    private Long seatId;

    @NotNull(message="status is required")
    private ShowSeatStatus status;
    
}
