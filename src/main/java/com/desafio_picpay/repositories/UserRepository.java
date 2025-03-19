package com.desafio_picpay.repositories;

import com.desafio_picpay.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findUserByDocument(String document);
    Optional<User> findUserById(String id);
    UserDetails findUserByEmail(String email);
}
