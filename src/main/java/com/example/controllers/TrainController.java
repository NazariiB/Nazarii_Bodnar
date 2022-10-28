package com.example.controllers;

import com.example.dto.Train;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class TrainController {
    Logger logger = LoggerFactory.getLogger(TrainController.class);
    @PostMapping("/train")
    public Train createTrain(@RequestBody Train newTrain) {
        logger.info("create train");
        return Train.builder()
                .id(UUID.randomUUID().hashCode())
                .arrivalTime(newTrain.getArrivalTime())
                .finaL(newTrain.getFinaL())
                .departureTime(newTrain.getDepartureTime())
                .first(newTrain.getFirst())
                .freeSeats(newTrain.getFreeSeats())
                .prize(newTrain.getPrize()).build();
    }

    @GetMapping("/trains")
    public List<Train> getTrains() {
        return Collections.emptyList();
    }

    @GetMapping("/train")
    public List<Train> getTrain(@RequestParam String id) {
        return Collections.emptyList();
    }

    @DeleteMapping("/train")
    public Train deleteTrain(@RequestParam String id){
        logger.info("delete train");
        return Train.builder().build();
    }

    @PutMapping("/train")
    public Train updateTrain(@RequestBody Train train) {
        logger.info("update train");
        return Train.builder().build();
    }
}
