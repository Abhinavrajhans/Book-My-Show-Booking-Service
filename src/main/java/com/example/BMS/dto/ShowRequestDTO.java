package com.example.BMS.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowRequestDTO {



    @NotNull(message="Start Time is Required")
    private Date startTime;

    @NotNull(message="End Time is Required")
    private Date endTime;

    @NotNull(message="Auditorium is Required")
    private Long auditoriumId;

    @NotNull(message="Movie id is Required")
    private Long movieId;


}
