package com.example.demo.serverClasses;

import java.util.Date;

public class CreditCard {
    private String cardNumber;
    private Date cardExpire;
    private String cardHolderName;
    private String cardHolderSurname;
    private int cvcCode;

    public CreditCard(String cardNumber, Date cardExpire, String cardHolderName, String cardHolderSurname, int cvcCode) {
        this.cardNumber = cardNumber;
        this.cardExpire = cardExpire;
        this.cardHolderName = cardHolderName;
        this.cardHolderSurname = cardHolderSurname;
        this.cvcCode = cvcCode;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Date getCardExpire() {
        return cardExpire;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getCardHolderSurname() {
        return cardHolderSurname;
    }

    public int getCvcCode() {
        return cvcCode;
    }
}
