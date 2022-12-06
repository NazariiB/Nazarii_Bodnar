package com.example.controller;

import com.example.dto.TrainDTO;
import com.example.dto.group.OnCreate;
import com.example.dto.group.OnUpdate;
import com.example.model.Train;
import com.example.service.TrainService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/train")
@RequiredArgsConstructor
public class TrainController {
    private final TrainService trainService;

    @GetMapping("/all")
    public ResponseEntity<List<TrainDTO>> getAll() {
        return new ResponseEntity<>(trainService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainDTO> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(trainService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTrain(@PathVariable Integer id) {
        log.info("delete request");
        trainService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<TrainDTO> createTrain(@RequestBody @Validated(OnCreate.class) TrainDTO train) {
        log.info("post train request");
        return new ResponseEntity<>(trainService.creat(train), HttpStatus.OK);
    }

    @PutMapping("/")
    public ResponseEntity<TrainDTO> updateTrain(@RequestBody @Validated(OnUpdate.class) TrainDTO train) {
        log.info("put train request");
        return new ResponseEntity<>(trainService.update(train),HttpStatus.OK);
    }

    @PutMapping("/{id}/ticket/{amountSeats}")
    public ResponseEntity<?> bookTickets(@PathVariable Integer id, @PathVariable Integer amountSeats) {
        log.info("put tickets request");
        trainService.bookPlace(id, amountSeats);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
