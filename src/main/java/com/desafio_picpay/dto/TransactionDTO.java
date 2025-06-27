package com.desafio_picpay.dto;

import com.desafio_picpay.domain.transaction.Transaction;

import java.math.BigDecimal;
import java.util.UUID;

public record TransactionDTO(BigDecimal value, UUID senderId, UUID receiverId) {

    public static TransactionDTO fromEntity(Transaction transaction) {
        return new TransactionDTO(
                transaction.getAmount(),
                transaction.getSender().getId(),
                transaction.getReceiver().getId()
        );
    }
}
