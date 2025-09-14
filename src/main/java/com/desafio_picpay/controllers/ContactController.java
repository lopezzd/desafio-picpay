package com.desafio_picpay.controllers;

import com.desafio_picpay.domain.transaction.Transaction;
import com.desafio_picpay.dto.TransactionDTO;
import com.desafio_picpay.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{id}/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    private ResponseEntity<Transaction> createTransaction(@RequestBody TransactionDTO transaction) throws Exception{
        Transaction newTransaction = this.contactService.createContact(transaction);
        return new ResponseEntity<>(newTransaction, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllContacs(){
        List<Transaction> transactions = this.contactService.getContactsByUserId();
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
