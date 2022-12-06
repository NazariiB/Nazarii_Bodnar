package com.example.service.ServiceImpl;

import com.example.dto.UserDTO;
import com.example.dto.assembler.UserAssembler;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserAssembler userAssembler;

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getAll() {
        return new ArrayList<>(userAssembler.toCollectionModel(userRepository.getAll()).getContent());
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return userAssembler.toModel(userRepository.getUserByUsername(username));
    }

    @Override
    public UserDTO getById(Integer id) {
        return userAssembler.toModel(userRepository.getById(id));
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO creat(UserDTO user) {
        return userAssembler.toModel(userRepository.creat(userAssembler.toDTO(user)));
    }

    @Override
    public UserDTO update(UserDTO user) {
        return userAssembler.toModel(userRepository.update(userAssembler.toDTO(user)));
    }
}
