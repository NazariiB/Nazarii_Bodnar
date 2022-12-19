package com.example.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "tickets", schema = "home_work")
public class Tickets extends RepresentationModel<Tickets> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="train_id")
    private Train train;

    @Column(name = "amountTickets")
    private int amountTickets;
}
