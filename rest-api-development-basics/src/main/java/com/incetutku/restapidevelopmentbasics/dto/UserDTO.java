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
    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    @NotEmpty
    @Email
    private String emailAddress;
}
