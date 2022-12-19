package com.example.service.impl;

import com.example.exception.ItemNotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public void update(Integer id, User user) {
        User updatedUser = userRepository.findById(id).orElseThrow(ItemNotFoundException::new);
        updatedUser.setUsername(user.getUsername());
        updatedUser.setAddress(user.getAddress());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setPassword(user.getPassword());
        userRepository.save(updatedUser);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getByUserName(String username) {
        return userRepository.findByUsername(username).orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public boolean isPasswordCorrect(String username, String password) {
        return userRepository.existsByUsernameAndPassword(username, password);
    }
}
