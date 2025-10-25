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
public class Theatre extends BaseModel{

    private String name;
    private String address;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy="theatre", cascade = CascadeType.ALL)
    private List<Auditorium> audotoriumList;
}
