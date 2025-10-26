package com.example.BMS.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.awt.print.Book;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeat extends BaseModel{

    @NotNull(message="Show is required")
    @ManyToOne
    private Show show;

    @NotNull(message="Seat is required")
    @ManyToOne
    private Seat seat;

    @NotNull(message="Status is required")
    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus status;

    @NotNull(message="Ticket is required")
    @ManyToOne
    private Ticket ticket;
}
