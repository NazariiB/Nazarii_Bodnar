package com.example.repository.impl;

import com.example.exception.ItemExistException;
import com.example.exception.ItemNotFoundException;
import com.example.model.User;
import com.example.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Repository
public class UserRepositoryImpl implements UserRepository {
    private final List<User> list = new ArrayList<>();

    @Override
    public List<User> getAll() {
        return list;
    }

    @Override
    public User getUserByUsername(String username) {
        return list.stream().filter(user -> user.getUsername().equals(username)).findFirst().orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public User getById(Integer id) {
        return list.stream().filter(user -> user.getId() == id).findFirst().orElseThrow(ItemNotFoundException::new);
    }

    @Override
    public void deleteById(Integer id) {
        log.info("delete user id:" + id);
        list.removeIf(user -> user.getId() != id);
    }

    @Override
    public User creat(User user) {
        if(list.stream().anyMatch(item -> item.getUsername().equals(user.getUsername()))) {
            throw new ItemExistException();
        }
        int uniqueID = UUID.randomUUID().hashCode();
        user.setId(Math.abs(uniqueID));
        list.add(user);
        log.info("create user id:" + uniqueID);
        return user;
    }

    @Override
    public User update(User user) {
        log.info("update user id:" + user.getId());
        if (list.removeIf(item -> item.getId() == user.getId())) {
            list.add(user);
        } else {
            throw new ItemNotFoundException();
        }
        return user;
    }
}
