package com.incetutku.restapidevelopmentbasics.service;

import com.incetutku.restapidevelopmentbasics.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(UserDTO userDTO);

    void deleteUserById(Long id);
}
