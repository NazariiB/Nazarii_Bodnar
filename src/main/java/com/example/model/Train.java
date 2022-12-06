package com.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Train {
    private int id;
    private String first;
    private String departureTime;
    private String finalStation;
    private String arrivalTime;
    private int freeSeats;
    private int price;
}
