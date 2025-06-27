package com.desafio_picpay.domain.user;

public enum UserType {
    COMMUN("commun"),
    MERCHANT("merchant");

    private String type;

    UserType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
