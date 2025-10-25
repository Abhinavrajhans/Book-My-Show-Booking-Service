package com.example.BMS.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name="movie")
@Getter
@Setter
public class Movie extends BaseModel{

    private String name;
    private String poster;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Show> shows;

}
