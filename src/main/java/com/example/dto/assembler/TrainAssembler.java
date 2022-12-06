package com.example.dto.assembler;

import com.example.dto.TrainDTO;
import com.example.dto.UserDTO;
import com.example.model.Train;
import com.example.model.User;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class TrainAssembler implements RepresentationModelAssembler<Train, TrainDTO> {

    @Override
    public TrainDTO toModel(Train train) {
        return TrainDTO.builder()
                .id(train.getId())
                .arrivalTime(train.getArrivalTime())
                .departureTime(train.getDepartureTime())
                .finalStation(train.getFinalStation())
                .first(train.getFirst())
                .freeSeats(train.getFreeSeats())
                .price(train.getPrice()).build();
    }

    @Override
    public CollectionModel<TrainDTO> toCollectionModel(Iterable<? extends Train> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }

    public Train toDTO(TrainDTO train) {
        return Train.builder()
                .id(train.getId())
                .arrivalTime(train.getArrivalTime())
                .departureTime(train.getDepartureTime())
                .finalStation(train.getFinalStation())
                .first(train.getFirst())
                .freeSeats(train.getFreeSeats())
                .price(train.getPrice()).build();
    }
}
