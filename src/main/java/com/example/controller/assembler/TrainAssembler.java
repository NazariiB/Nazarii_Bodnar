package com.example.controller.assembler;

import com.example.controller.TrainController;
import com.example.controller.UserController;
import com.example.dto.TrainDTO;
import com.example.dto.UserDTO;
import com.example.model.Train;
import com.example.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
@RequiredArgsConstructor
public class TrainAssembler implements RepresentationModelAssembler<Train, TrainDTO> {
    @Override
    public TrainDTO toModel(Train train) {
        TicketsAssembler ticketsAssembler = new TicketsAssembler();
        TrainDTO trainDTO = TrainDTO.builder()
                .tickets(new ArrayList<>(ticketsAssembler.toCollectionModel(train.getTickets()).getContent()))
                .id(train.getId())
                .first(train.getFirst())
                .finalStation(train.getFinalStation())
                .departureTime(train.getDepartureTime())
                .arrivalTime(train.getArrivalTime())
                .freeSeats(train.getFreeSeats())
                .price(train.getPrice())
                .build();
        trainDTO.add(linkTo(methodOn(TrainController.class).getById(train.getId())).withSelfRel());
        return trainDTO;
    }

    @Override
    public CollectionModel<TrainDTO> toCollectionModel(Iterable<? extends Train> entities) {
        CollectionModel<TrainDTO> trainDTO = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(TrainController.class).getAll()).withSelfRel();
        trainDTO.add(selfLink);
        return trainDTO;
    }
}
