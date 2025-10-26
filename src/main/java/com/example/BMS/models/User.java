package com.example.BMS.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseModel {

    @NotBlank(message="Name is Required")
    private String name;

    @NotBlank(message="Email is Required")
    @Email(message="Email format is invalid")
    private String email;

    @OneToMany(mappedBy="user")
    private List<Ticket> tickets;



}
