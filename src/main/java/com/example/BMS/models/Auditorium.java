package com.example.BMS.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Auditorium extends BaseModel{

    @NotBlank(message="name is required")
    @Size(min=2,max=100,message="The name must be between 2 and 100 characters")
    private String name;

    @NotNull(message="capacity is required")
    private int capacity;

    @ManyToOne
    private Theatre theatre;

    @OneToMany(mappedBy="auditorium",cascade= CascadeType.ALL)
    private List<Seat> seats;

    @OneToMany(mappedBy="auditorium" , cascade = CascadeType.ALL)
    private List<Show> shows;


}
