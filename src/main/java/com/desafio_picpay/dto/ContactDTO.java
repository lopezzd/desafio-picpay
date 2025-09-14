package com.desafio_picpay.dto;

import com.desafio_picpay.domain.contact.Contact;
import com.desafio_picpay.domain.contact.ContactType;

import java.util.UUID;

public record ContactDTO(ContactType contactType, UUID ownerId) {

    public static ContactDTO fromEntity(Contact contact) {
        return new ContactDTO(
                contact.getContacType(),
                contact.getOwner().getId()
        );
    }
}
