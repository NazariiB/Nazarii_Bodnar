package com.example.controller.assembler;

import com.example.controller.UserController;
import com.example.dto.UserDTO;
import com.example.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class UserAssembler implements RepresentationModelAssembler<User, UserDTO> {

    @Override
    public UserDTO toModel(User user) {
        TicketsAssembler ticketsAssembler = new TicketsAssembler();
        UserDTO userDTO = UserDTO.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .address(user.getAddress())
                .email(user.getEmail())
                .id(user.getId())
                .tickets(user.getTickets() != null ?
                        new ArrayList<>(ticketsAssembler.toCollectionModel(user.getTickets()).getContent()) : new ArrayList<>())
                .build();
        userDTO.add(linkTo(methodOn(UserController.class).getById(user.getId())).withSelfRel(),
         linkTo(methodOn(UserController.class).getByUsername(user.getUsername())).withSelfRel());
        return userDTO;
    }

    @Override
    public CollectionModel<UserDTO> toCollectionModel(Iterable<? extends User> entities) {
        CollectionModel<UserDTO> usersDTO = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(UserController.class).getAll()).withSelfRel();
        usersDTO.add(selfLink);
        return usersDTO;
    }
}
