package com.example.BMS.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseModel{

    private int amount;

    @ManyToOne
    private User user;

    @ManyToOne
    private Show show;

    @OneToMany(mappedBy = "ticket")
    private List<ShowSeat> showSeat;

    @Enumerated(EnumType.ORDINAL)
    private TicketStatus status;


}
