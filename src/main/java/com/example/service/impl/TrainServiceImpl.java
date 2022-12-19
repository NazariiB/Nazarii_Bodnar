package com.example.service.impl;

import com.example.exception.ItemNotFoundException;
import com.example.model.Train;
import com.example.repository.TrainRepository;
import com.example.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainServiceImpl implements TrainService {
    private final TrainRepository trainRepository;
    @Override
    public List<Train> findAll() {
        return trainRepository.findAll();
    }

    @Override
    public Train findById(Integer id) {
        return trainRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public Train create(Train train) {
        return trainRepository.save(train);
    }

    @Override
    public void update(Integer id, Train newTrain) {
        Train oldTrain = trainRepository.findById(id).orElseThrow(ItemNotFoundException::new);
        oldTrain.setFreeSeats(newTrain.getFreeSeats());
        oldTrain.setFirst(newTrain.getFirst());
        oldTrain.setDepartureTime(newTrain.getDepartureTime());
        oldTrain.setFinalStation(newTrain.getFinalStation());
        oldTrain.setArrivalTime(newTrain.getArrivalTime());
        oldTrain.setPrice(newTrain.getPrice());
        trainRepository.save(oldTrain);
    }

    @Override
    public void delete(Integer id) {
        trainRepository.deleteById(id);
    }
}
