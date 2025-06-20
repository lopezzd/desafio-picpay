package com.desafio_picpay.dto;

import com.desafio_picpay.domain.user.UserType;

import java.math.BigDecimal;

public record UpdateUserDTO(String firstName, String lastName, String document, String email, String password) {
}
