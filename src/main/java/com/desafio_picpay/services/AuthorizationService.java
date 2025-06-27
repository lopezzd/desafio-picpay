package com.desafio_picpay.services;

import com.desafio_picpay.domain.user.User;
import com.desafio_picpay.dto.UserDTO;
import com.desafio_picpay.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorizationService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username).orElseThrow();
    }

    public Optional<User> createUser(UserDTO data) {
        Optional<User> user = this.repository.findByEmail(data.email());

        if (user.isPresent()) {
            return Optional.empty();
        }

        User newUser = new User(
                data.firstName(),
                data.lastName(),
                data.document(),
                data.email(),
                passwordEncoder.encode(data.password()),
                data.balance(),
                data.userType()
        );


        this.repository.save(newUser);

        return Optional.of(newUser);
    }

}

