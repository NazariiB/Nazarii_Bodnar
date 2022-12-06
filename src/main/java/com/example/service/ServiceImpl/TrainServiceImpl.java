package com.example.service.ServiceImpl;

import com.example.dto.TrainDTO;
import com.example.dto.assembler.TrainAssembler;
import com.example.repository.TrainRepository;
import com.example.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainServiceImpl implements TrainService {
    private final TrainRepository trainRepository;

    private final TrainAssembler trainAssembler;

    @Override
    public List<TrainDTO> getAll() {
        return new ArrayList<>(trainAssembler.toCollectionModel(trainRepository.getAll()).getContent());
    }

    @Override
    public TrainDTO getById(Integer id) {
        return trainAssembler.toModel(trainRepository.getById(id));
    }

    @Override
    public void deleteById(Integer id) {
        trainRepository.deleteById(id);
    }

    @Override
    public TrainDTO creat(TrainDTO train) {
        return trainAssembler.toModel(trainRepository.creat(trainAssembler.toDTO(train)));
    }

    @Override
    public TrainDTO update(TrainDTO train) {
        return trainAssembler.toModel(trainRepository.update(trainAssembler.toDTO(train)));
    }

    @Override
    public void bookPlace(Integer id, Integer amountSeats) {
        trainRepository.bookPlace(id, amountSeats);
    }
}
