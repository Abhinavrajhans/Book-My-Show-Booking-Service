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
public class Theatre extends BaseModel{


    @NotBlank(message="Name is required")
    @Size(min=1, max=50,message="Name must be between 1 and 50 characters")
    private String name;

    @NotBlank(message = "Address is required")
    @Size(min=5 ,max=1000 , message = "Address must be between 5 and 1000 characters")
    private String address;

    @ManyToOne
    @NotNull(message="City is required")
    private City city;

    @OneToMany(mappedBy="theatre", cascade = CascadeType.ALL)
    private List<Auditorium> audotoriumList;
}
