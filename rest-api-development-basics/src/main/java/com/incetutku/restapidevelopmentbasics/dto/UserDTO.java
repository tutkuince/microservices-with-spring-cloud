package com.incetutku.restapidevelopmentbasics.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "UserDTO Model Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    @Schema(
            description = "User Name"
    )
    @NotEmpty(message = "User's Name should not be null or empty")
    private String name;
    @Schema(
            description = "User Surname"
    )
    @NotEmpty(message = "User's Surname should not be null or empty")
    private String surname;
    @Schema(
            description = "User Email"
    )
    @NotEmpty(message = "User's email should not be null or empty")
    @Email(message = "Email address should be valid")
    private String emailAddress;
}
