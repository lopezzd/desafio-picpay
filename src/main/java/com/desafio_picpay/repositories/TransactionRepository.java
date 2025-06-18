package com.desafio_picpay.repositories;

import com.desafio_picpay.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findBySenderId(UUID senderId);

}
