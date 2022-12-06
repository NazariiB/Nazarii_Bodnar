package com.example.service;

import com.example.dto.UserDTO;


public interface UserService extends BaseInterface<UserDTO> {
    UserDTO getUserByUsername(String username);

}
