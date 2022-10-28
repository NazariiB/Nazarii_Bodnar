package com.example.controllers;

import com.example.dto.Train;
import com.example.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/user")
    public User createUser(@RequestBody User newUser) {
        return User.builder()
                .id(UUID.randomUUID().hashCode())
                .firstName(newUser.getFirstName())
                .lastName(newUser.getLastName())
                .username(newUser.getUsername())
                .password(newUser.getPassword())
                .address(newUser.getAddress())
                .contact(newUser.getContact())
                .role(newUser.getRole()).build();
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return Collections.emptyList();
    }

    @GetMapping("/user")
    public List<User> getUser(@RequestParam String id) {
        return Collections.emptyList();
    }

    @DeleteMapping("/user")
    public User deleteUser(@RequestParam String id){
        logger.info("delete user");
        return User.builder().build();
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User train) {
        logger.info("update user");
        return User.builder().build();
    }
}
