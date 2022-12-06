package com.example.repository;

import com.example.model.User;

import java.util.List;

public interface UserRepository extends CRUDoperations<User> {
    List<User> getAll();

    User getUserByUsername(String username);

    User getById(Integer id);

    void deleteById(Integer id);

    User creat(User user);

    User update(User user);
}
