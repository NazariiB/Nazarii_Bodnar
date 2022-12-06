package com.example.controller;

import com.example.dto.TicketsDTO;
import com.example.dto.group.OnCreate;
import com.example.dto.group.OnUpdate;
import com.example.service.TicketsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketsService ticketsService;

    @GetMapping("/all")
    public ResponseEntity<List<TicketsDTO>> getAll() {
        return new ResponseEntity<>(ticketsService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketsDTO> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(ticketsService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        log.info("delete request");
        ticketsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<TicketsDTO> create(@RequestBody @Validated(OnCreate.class) TicketsDTO tickets) {
        log.info("create request");
        return new ResponseEntity<>(ticketsService.creat(tickets), HttpStatus.CREATED);
    }

    @PutMapping("/")
    public ResponseEntity<TicketsDTO> update(@RequestBody @Validated(OnUpdate.class) TicketsDTO tickets) {
        log.info("update request");
        return new ResponseEntity<>(ticketsService.update(tickets), HttpStatus.OK);
    }
}
