package com.example.service;

import com.example.model.User;

public interface UserService extends GeneralService<User, Integer> {
    User getByUserName(String username);
    boolean isPasswordCorrect(String username, String password);
}
