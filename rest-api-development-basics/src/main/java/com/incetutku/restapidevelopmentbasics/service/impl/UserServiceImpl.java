package com.incetutku.restapidevelopmentbasics.service.impl;

import com.incetutku.restapidevelopmentbasics.dto.UserDTO;
import com.incetutku.restapidevelopmentbasics.entity.User;
import com.incetutku.restapidevelopmentbasics.exception.EmailAlreadyExistException;
import com.incetutku.restapidevelopmentbasics.exception.ResourceNotFoundException;
import com.incetutku.restapidevelopmentbasics.mapper.UserMapper;
import com.incetutku.restapidevelopmentbasics.repository.UserRepository;
import com.incetutku.restapidevelopmentbasics.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmailAddress());
        if (optionalUser.isPresent()) {
            throw new EmailAlreadyExistException("Email Already Exists for User");
        }
        User user = UserMapper.USER_MAPPER.mapToUser(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.USER_MAPPER.mapToUserDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.map(UserMapper.USER_MAPPER::mapToUserDTO).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper.USER_MAPPER::mapToUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        User existingUser = userRepository.findById(userDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userDTO.getId()));
        existingUser.setName(userDTO.getName());
        existingUser.setSurname(userDTO.getSurname());
        existingUser.setEmail(userDTO.getEmailAddress());
        User updatedUser = userRepository.save(existingUser);
        return UserMapper.USER_MAPPER.mapToUserDTO(updatedUser);

    }

    @Override
    public void deleteUserById(Long id) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "Id", id));
        userRepository.deleteById(id);
    }
}
