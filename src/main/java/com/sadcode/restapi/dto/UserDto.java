package com.sadcode.restapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotEmpty(message = "User first name should not be null or empty.")
    private String firstName;


    @NotEmpty(message = "User last name should not be null or empty.")
    private String lastName;

    @NotEmpty(message = "User email name should not be null or empty.")
    @Email(message = "email address should be valid")
    private String email;

}
