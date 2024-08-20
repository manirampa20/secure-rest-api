package com.example.api_security.controller;

import com.example.api_security.model.UserDTO;
import org.owasp.encoder.Encode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
@Validated
public class UserController {

    @PostMapping("/validate")
    public ResponseEntity<String> validateEmail(@Valid @RequestBody UserDTO userDTO) {
        // Encode the email before returning it to prevent XSS attacks
        String encodedEmail = Encode.forHtml(userDTO.getEmail());

        return new ResponseEntity<>("Valid email: " + encodedEmail, HttpStatus.OK);

    }
}
