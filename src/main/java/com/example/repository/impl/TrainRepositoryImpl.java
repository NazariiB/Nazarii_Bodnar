package com.example.repository.impl;

import com.example.exception.ItemNotFoundException;
import com.example.exception.NoFreeSeatsException;
import com.example.model.Train;
import com.example.repository.TrainRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Repository
public class TrainRepositoryImpl implements TrainRepository {

    private final List<Train> list = new ArrayList<>();
    @Override
    public List<Train> getAll() {
        return list;
    }

    @Override
    public Train getById(Integer id) {
        return list.stream().filter(user -> user.getId() == id).findFirst().orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public void deleteById(Integer id) {
        log.info("delete train id:" + id);
        list.removeIf(user -> user.getId() != id);
    }

    @Override
    public Train creat(Train train) {
        int uniqueID = UUID.randomUUID().hashCode();
        train.setId(Math.abs(uniqueID));
        list.add(train);
        log.info("create train id:" + uniqueID);
        return train;
    }

    @Override
    public Train update(Train train) {
        log.info("update train id:" + train.getId());
        if (list.removeIf(item -> item.getId() == train.getId())) {
            list.add(train);
        } else {
            throw new ItemNotFoundException();
        }
        return train;
    }

    @Override
    public void bookPlace(Integer id, Integer amountSeats) {
        log.info("booked places: " + amountSeats);
        Train searchedTrain = list.stream().filter(item -> item.getId() == id).findFirst().orElseThrow(ItemNotFoundException::new);
        if(amountSeats > 0 && searchedTrain.getFreeSeats() >= amountSeats) {
            searchedTrain.setFreeSeats(searchedTrain.getFreeSeats() - amountSeats);
        } else {
            throw new NoFreeSeatsException();
        }
    }
}
