package com.example.service.ServiceImpl;

import com.example.dto.TicketsDTO;
import com.example.dto.assembler.TicketsAssembler;
import com.example.repository.TicketsRepository;
import com.example.service.TicketsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketsServiceImpl implements TicketsService {

    private final TicketsAssembler ticketsAssembler;

    private final TicketsRepository ticketsRepository;

    @Override
    public List<TicketsDTO> getAll() {
        return new ArrayList<>(ticketsAssembler.toCollectionModel(ticketsRepository.getAll()).getContent());
    }

    @Override
    public TicketsDTO getById(Integer id) {
        return ticketsAssembler.toModel(ticketsRepository.getById(id));
    }

    @Override
    public void deleteById(Integer id) {
        ticketsRepository.deleteById(id);
    }

    @Override
    public TicketsDTO creat(TicketsDTO tickets) {
        return ticketsAssembler.toModel(ticketsRepository.creat(ticketsAssembler.fromDTO(tickets)));
    }

    @Override
    public TicketsDTO update(TicketsDTO tickets) {
        return ticketsAssembler.toModel(ticketsRepository.update(ticketsAssembler.fromDTO(tickets)));
    }
}
