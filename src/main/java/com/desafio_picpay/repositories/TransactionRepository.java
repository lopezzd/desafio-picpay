package com.desafio_picpay.repositories;

import com.desafio_picpay.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
