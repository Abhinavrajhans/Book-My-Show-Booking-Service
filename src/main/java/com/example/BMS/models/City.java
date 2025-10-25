package com.example.BMS.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City extends BaseModel{

    private String name;


    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Theatre> theatres;

}
