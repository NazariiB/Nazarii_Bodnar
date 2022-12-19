package com.example.service.impl;

import com.example.exception.ItemNotFoundException;
import com.example.model.Tickets;
import com.example.repository.TicketsRepository;
import com.example.service.TicketsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketsServiceImpl implements TicketsService {
    public final TicketsRepository ticketsRepository;
    @Override
    public List<Tickets> findAll() {
        return ticketsRepository.findAll();
    }

    @Override
    public Tickets findById(Integer id) {
        return ticketsRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public Tickets create(Tickets tickets) {
        return ticketsRepository.save(tickets);
    }

    @Override
    public void update(Integer id, Tickets newTicket) {
        Tickets oldTickets = ticketsRepository.findById(id).orElseThrow(ItemNotFoundException::new);
        oldTickets.setUser(newTicket.getUser());
        oldTickets.setTrain(newTicket.getTrain());
        oldTickets.setAmountTickets(newTicket.getAmountTickets());
        ticketsRepository.save(oldTickets);
    }

    @Override
    public void delete(Integer id) {
        ticketsRepository.deleteById(id);
    }
}
