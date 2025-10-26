package com.example.BMS.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseModel{

    @NotNull(message = "Amount is required")
    private int amount;

    @NotNull(message = "User is required")
    @ManyToOne
    private User user;

    @NotNull(message = "Show is required")
    @ManyToOne
    private Show show;

    @OneToMany(mappedBy = "ticket")
    private List<ShowSeat> showSeat;

    @NotNull(message = "Status is required")
    @Enumerated(EnumType.ORDINAL)
    private TicketStatus status;


}
