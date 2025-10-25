package com.example.BMS.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity(name="movie")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends BaseModel{

    private String name;
    private String poster;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Show> shows;

}
