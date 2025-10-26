package com.example.BMS.models;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City extends BaseModel{

    @NotBlank(message="name is Required")
    private String name;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Theatre> theatres;

}
