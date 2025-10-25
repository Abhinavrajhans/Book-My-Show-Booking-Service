package com.example.BMS.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity(name="shows")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Show extends BaseModel{

    @ManyToOne
    private Movie movie;

    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Auditorium auditorium;

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeatList;

    @OneToMany(mappedBy="show")
    private List<Ticket> tickets;


}
