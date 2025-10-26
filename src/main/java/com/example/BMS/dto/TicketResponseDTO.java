package com.example.BMS.dto;

import com.example.BMS.models.TicketStatus;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketResponseDTO {

    private Long id;
    private int amount;
    private TicketStatus status;
}
