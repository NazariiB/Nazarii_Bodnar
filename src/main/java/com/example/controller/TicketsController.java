package com.example.controller;

import com.example.controller.assembler.TicketsAssembler;
import com.example.dto.TicketsDTO;
import com.example.model.Tickets;
import com.example.service.TicketsService;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketsController {
    public final TicketsService ticketsService;

    public final TicketsAssembler ticketsAssembler;

    @GetMapping("/")
    public ResponseEntity<CollectionModel<TicketsDTO>> getAll() {
        return new ResponseEntity<>(ticketsAssembler.toCollectionModel(ticketsService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TicketsDTO> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(ticketsAssembler.toModel(ticketsService.findById(id)), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<TicketsDTO> create(@RequestBody Tickets tickets) {
        return new ResponseEntity<>(ticketsAssembler.toModel(ticketsService.create(tickets)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Tickets tickets) {
        ticketsService.update(id, tickets);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        ticketsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
