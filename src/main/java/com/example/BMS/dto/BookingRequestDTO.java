package com.example.BMS.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingRequestDTO {

    private List<Long> showSeatIds;
    private Long showId;
    private Long userId;
}
