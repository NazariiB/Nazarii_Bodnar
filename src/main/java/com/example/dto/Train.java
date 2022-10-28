package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Train {
    private int id;
    private String first;
    private String departureTime;
    private String finaL;
    private String arrivalTime;
    private int freeSeats;
    private int prize;
}
