package com.example.BMS.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Auditorium extends BaseModel{

    private String name;
    private int capacity;

    @ManyToOne
    private Theatre theatre;

    @OneToMany(mappedBy="auditorium",cascade= CascadeType.ALL)
    private List<Seat> seats;

    @OneToMany(mappedBy="auditorium" , cascade = CascadeType.ALL)
    private List<Show> shows;


}
