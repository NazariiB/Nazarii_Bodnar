package com.example.controller.assembler;

import com.example.controller.TicketsController;
import com.example.controller.UserController;
import com.example.dto.TicketsDTO;
import com.example.model.Tickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TicketsAssembler implements RepresentationModelAssembler<Tickets, TicketsDTO> {
    @Autowired
    private UserAssembler userAssembler;

    @Autowired
    private TrainAssembler trainAssembler;

    @Override
    public TicketsDTO toModel(Tickets ticket) {
        TicketsDTO ticketsDTO = TicketsDTO.builder()
                .amountTickets(ticket.getAmountTickets())
                .id(ticket.getId())
                .user(userAssembler.toModel(ticket.getUser()))
                .train(trainAssembler.toModel(ticket.getTrain()))
                .build();
        ticketsDTO.add(linkTo(methodOn(TicketsController.class).getById(ticket.getId())).withSelfRel());
        return ticketsDTO;
    }

    @Override
    public CollectionModel<TicketsDTO> toCollectionModel(Iterable<? extends Tickets> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }
}
