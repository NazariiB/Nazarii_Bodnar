package com.example.service;

import com.example.dto.TrainDTO;

public interface TrainService extends BaseInterface<TrainDTO> {
    void bookPlace(Integer id, Integer amountSeats);
}
