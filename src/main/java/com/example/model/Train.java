package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "train")
public class Train extends RepresentationModel<Train> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first")
    private String first;
    @Column(name = "departure_time")
    private String departureTime;
    @Column(name = "final_station")
    private String finalStation;
    @Column(name = "arrival_time")
    private String arrivalTime;
    @Column(name = "free_seats")
    private int freeSeats;
    @Column(name = "price")
    private int price;
    @OneToMany( fetch = FetchType.LAZY, mappedBy = "train")
    private List<Tickets> tickets;
}
