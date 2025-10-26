package com.example.BMS.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Seat extends BaseModel {

    @NotNull(message="Seat Number Is Required")
    private String seatNumber;

    @NotNull(message="Row Value is Required")
    private int rowValue;

    @NotNull(message="Row Value is Required")
    private int columnValue;

    @Enumerated(EnumType.ORDINAL) // what is ordinal it is not going to store the actual seat type value instead it is going to store the asscoiated number
    // if we keep the string then it will store the string but string type searches is expensive.
    @NotNull(message="Seat Type is Required")
    private SeatType seatType;

    @ManyToOne
    private Auditorium auditorium;

    @OneToMany(mappedBy="seat" , fetch = FetchType.LAZY)
    private List<ShowSeat> showSeatList;


}
