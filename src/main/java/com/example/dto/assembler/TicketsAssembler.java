package com.example.dto.assembler;

import com.example.dto.TicketsDTO;
import com.example.model.Tickets;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class TicketsAssembler implements RepresentationModelAssembler<Tickets, TicketsDTO> {
    @Override
    public TicketsDTO toModel(Tickets tickets) {
        return TicketsDTO.builder()
                .id(tickets.getId())
                .amountTickets(tickets.getAmountTickets())
                .trainId(tickets.getTrainId())
                .userId(tickets.getUserId()).build();
    }

    @Override
    public CollectionModel<TicketsDTO> toCollectionModel(Iterable<? extends Tickets> entities) {
        return RepresentationModelAssembler.super.toCollectionModel(entities);
    }

    public Tickets fromDTO(TicketsDTO tickets) {
        return Tickets.builder()
                .id(tickets.getId())
                .amountTickets(tickets.getAmountTickets())
                .trainId(tickets.getTrainId())
                .userId(tickets.getUserId()).build();
    }
}
