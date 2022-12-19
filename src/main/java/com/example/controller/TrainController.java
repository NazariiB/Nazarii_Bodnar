package com.example.controller;

import com.example.controller.assembler.TrainAssembler;
import com.example.dto.TrainDTO;
import com.example.model.Train;
import com.example.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TrainController {
    private final TrainService trainService;

    private final TrainAssembler trainAssembler;

    @GetMapping("/")
    public ResponseEntity<CollectionModel<TrainDTO>> getAll() {
        return new ResponseEntity<>(trainAssembler.toCollectionModel(trainService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TrainDTO> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(trainAssembler.toModel(trainService.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TrainDTO> create(@RequestBody Train train) {
        return new ResponseEntity<>(trainAssembler.toModel(trainService.create(train)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Train train) {
        trainService.update(id, train);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        trainService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
