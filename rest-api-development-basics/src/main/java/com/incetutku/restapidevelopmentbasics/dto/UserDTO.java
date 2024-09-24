package com.incetutku.restapidevelopmentbasics.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    @NotEmpty(message = "User's Name should not be null or empty")
    private String name;
    @NotEmpty(message = "User's Surname should not be null or empty")
    private String surname;
    @NotEmpty(message = "User's email should not be null or empty")
    @Email(message = "Email address should be valid")
    private String emailAddress;
}
