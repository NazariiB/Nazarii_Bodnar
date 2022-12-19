package com.example.controller;

import com.example.controller.assembler.UserAssembler;
import com.example.dto.UserDTO;
import com.example.model.User;
import com.example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserAssembler userAssembler;

    @GetMapping("/all")
    public ResponseEntity<CollectionModel<UserDTO>> getAll() {
        return new ResponseEntity<>(userAssembler.toCollectionModel(userService.findAll()), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable int id) {
        return new ResponseEntity<>(userAssembler.toModel(userService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> getByUsername(@PathVariable String username) {
        return new ResponseEntity<>(userAssembler.toModel(userService.getByUserName(username)), HttpStatus.OK);
    }

    @GetMapping("/correct/{username}")
    public ResponseEntity<Boolean> isPasswordCorrect(@PathVariable String username, @RequestBody String password) {
        return new ResponseEntity<>(userService.isPasswordCorrect(username, password), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserDTO> create(@RequestBody User user) {
        return new ResponseEntity<>(userAssembler.toModel(userService.create(user)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody User user) {
        userService.update(id, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
