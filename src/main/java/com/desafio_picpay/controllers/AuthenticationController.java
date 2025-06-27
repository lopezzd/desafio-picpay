package com.desafio_picpay.controllers;

import com.desafio_picpay.domain.user.User;
import com.desafio_picpay.dto.AuthResponseDTO;
import com.desafio_picpay.dto.AuthenticationDTO;
import com.desafio_picpay.dto.UserDTO;
import com.desafio_picpay.repositories.UserRepository;
import com.desafio_picpay.services.AuthorizationService;
import com.desafio_picpay.services.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final AuthorizationService authorizationService;
    private final TokenService tokenService;
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO data) {

        User user = this.repository.findByEmail(data.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(data.password(), user.getPassword())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new AuthResponseDTO(user.getUsername(), token));
        }
        return ResponseEntity.badRequest().body("Credênciais incorretas");
    }

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody @Validated UserDTO data) {
        Optional<User> createdUser = authorizationService.createUser(data);

        if (createdUser.isPresent()) {
            return ResponseEntity.ok(createdUser.get());
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

