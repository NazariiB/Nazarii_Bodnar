package com.example.repository;

import com.example.dto.TrainDTO;
import com.example.model.Train;

public interface TrainRepository extends CRUDoperations<Train> {
    void bookPlace(Integer id, Integer amountSeats);
}
