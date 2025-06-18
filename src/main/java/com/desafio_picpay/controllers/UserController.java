package com.desafio_picpay.controllers;

import com.desafio_picpay.domain.user.User;
import com.desafio_picpay.dto.TransactionDTO;
import com.desafio_picpay.repositories.UserRepository;
import com.desafio_picpay.services.TransactionService;
import com.desafio_picpay.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserRepository repository;


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
