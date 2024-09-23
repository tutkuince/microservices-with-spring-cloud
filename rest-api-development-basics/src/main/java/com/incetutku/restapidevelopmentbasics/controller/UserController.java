package com.incetutku.restapidevelopmentbasics.controller;

import com.incetutku.restapidevelopmentbasics.dto.UserDTO;
import com.incetutku.restapidevelopmentbasics.exception.ErrorDetails;
import com.incetutku.restapidevelopmentbasics.exception.ResourceNotFoundException;
import com.incetutku.restapidevelopmentbasics.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.View;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final View error;

    public UserController(UserService userService, View error) {
        this.userService = userService;
        this.error = error;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUserById(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok("User successfully deleted");
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                exception.getMessage(),
                webRequest.getDescription(false),
                "USER_NOT_FOUND"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
