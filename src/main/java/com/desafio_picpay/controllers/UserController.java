package com.desafio_picpay.controllers;

import com.desafio_picpay.domain.user.User;
import com.desafio_picpay.domain.user.UserType;
import com.desafio_picpay.dto.UserDTO;
import com.desafio_picpay.repositories.UserRepository;
import com.desafio_picpay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository repository;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){

        if((this.repository.findUserByEmail(user.email()) != null) || (this.repository.findUserByDocument(user.document()) != null)) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(user.password());

        UserDTO encryptedPasswordUser = new UserDTO(user.firstName(), user.lastName(), user.document(), user.email(), encryptedPassword, user.balance(), user.userType());

        User newUser = userService.createUser(encryptedPasswordUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }



    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = this.userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getAllUsers(@PathVariable String document) throws Exception {
        User users = this.userService.findUserByDocument(document);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
