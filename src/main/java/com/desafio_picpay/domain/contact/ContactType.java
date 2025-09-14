package com.desafio_picpay.domain.contact;

public enum ContactType {
    PERSONAL("personal"),
    BUSINESS("business");

    private String type;

    ContactType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
