package com.example.BMS.dto;


import com.example.BMS.models.Ticket;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {

    @NotBlank(message="Name is Required")
    private String name;

    @NotBlank(message="Email is Required")
    @Email(message="Email format is invalid")
    private String email;

}
