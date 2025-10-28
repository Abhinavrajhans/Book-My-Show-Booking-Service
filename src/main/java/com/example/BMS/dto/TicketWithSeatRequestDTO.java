package com.example.BMS.dto;


import com.example.BMS.models.Show;
import com.example.BMS.models.ShowSeat;
import com.example.BMS.models.TicketStatus;
import com.example.BMS.models.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketWithSeatRequestDTO {


    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "Amount must be greater than 0")
    private int amount;

    @NotNull(message = "userId is required")
    private Long userId;

    @NotNull(message = "showId is required")
    private Long showId;

    @NotNull(message="seats are required")
    private List<Long> seatIds;

    @NotNull(message="status is required")
    private TicketStatus status;
}

