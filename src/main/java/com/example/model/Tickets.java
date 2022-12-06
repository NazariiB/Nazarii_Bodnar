package com.example.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Tickets {
    private int id;
    private int userId;
    private int trainId;
    private int amountTickets;
}
