package com.desafio_picpay.services;

import com.desafio_picpay.domain.contact.Contact;
import com.desafio_picpay.domain.user.User;
import com.desafio_picpay.dto.ContactDTO;
import com.desafio_picpay.dto.TransactionDTO;
import com.desafio_picpay.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ContactService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private ContactRepository repository;

    @Autowired
    private NotificationService notificationService;

    public Contact createContact(ContactDTO contact) throws Exception{
        User owner = this.userService.findUserById(contact.ownerId());

        Contact newContact = new Contact();

        this.repository.save(newContact);
        this.userService.saveUser(owner);

        this.notificationService.sendNotification(owner, "Contato criado!");

        return newContact;
    }


    public List<ContactDTO> getContactsByUserId(UUID userId) {
        List<Transaction> transactions = this.repository.findBySenderId(userId);
        return transactions.stream()
                .map(TransactionDTO::fromEntity)
                .toList();
    }

}
