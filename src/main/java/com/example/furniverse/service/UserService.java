package com.example.furniverse.service;

import com.example.furniverse.dto.RegisterRequest;
import com.example.furniverse.dto.UserDTO;
import com.example.furniverse.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDTO userDto);

    User findUserByEmail(String email);

    List<UserDTO> findAllUsers();

    void register(RegisterRequest request);

    String login(RegisterRequest request);
}
