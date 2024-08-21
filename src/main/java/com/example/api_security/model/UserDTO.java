package com.example.api_security.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserDTO {

    @NotNull(message = "Email cannot be null")
    @Email(message = "Email should be valid")
    @Pattern(regexp = ".+@.+\\..+", message = "Email must contain a valid domain")
    private String email;

    public UserDTO() {}

    public UserDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
