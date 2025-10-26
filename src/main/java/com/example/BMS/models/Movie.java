package com.example.BMS.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity(name="movie")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie extends BaseModel{

    @NotBlank(message="movie name is required")
    @Size(min=2,max=100, message="The name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message="poster is required")
    private String poster;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Show> shows;

}
