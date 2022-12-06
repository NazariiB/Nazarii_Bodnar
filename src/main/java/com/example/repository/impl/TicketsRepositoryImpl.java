package com.example.repository.impl;

import com.example.exception.ItemNotFoundException;
import com.example.model.Tickets;
import com.example.repository.TicketsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Repository
public class TicketsRepositoryImpl implements TicketsRepository {

    private final List<Tickets> list = new ArrayList<>();

    @Override
    public List<Tickets> getAll() {
        return list;
    }

    @Override
    public Tickets getById(Integer id) {
        return list.stream().filter(user -> user.getId() == id).findFirst().orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public void deleteById(Integer id) {
        list.removeIf(user -> user.getId() != id);
        log.info("delete tickets id:" + id);
    }

    @Override
    public Tickets creat(Tickets tickets) {
        int uniqueID = UUID.randomUUID().hashCode();
        tickets.setId(Math.abs(uniqueID));
        list.add(tickets);
        log.info("create tickets id:" + uniqueID);
        return tickets;
    }

    @Override
    public Tickets update(Tickets tickets) {
        log.info("update tickets id:" + tickets.getId());
        if (list.removeIf(item -> item.getId() == tickets.getId())) {
            list.add(tickets);
        } else {
            throw new ItemNotFoundException();
        }
        return tickets;
    }
}
