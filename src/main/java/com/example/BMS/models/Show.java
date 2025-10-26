package com.example.BMS.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message="Movie id is Required")
    private Movie movie;

    @NotNull(message="Start Time is Required")
    private Date startTime;

    @NotNull(message="End Time is Required")
    private Date endTime;

    @ManyToOne
    @NotNull(message="Auditorium is Required")
    private Auditorium auditorium;

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeatList;

    @OneToMany(mappedBy="show")
    private List<Ticket> tickets;

}
