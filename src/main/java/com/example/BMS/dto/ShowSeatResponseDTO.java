package com.example.BMS.dto;


import com.example.BMS.models.ShowSeatStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowSeatResponseDTO {

    private Long id;
    private ShowSeatStatus status;
}
