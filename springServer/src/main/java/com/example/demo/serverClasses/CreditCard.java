package com.example.demo.serverClasses;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@Entity
public class CreditCard {
    @Id
    private long cardId;
    private String cardNumber;
    private Date cardExpire;
    private String cardHolderName;
    private String cardHolderSurname;
    private final int cvcCode;

    public CreditCard(String cardNumber, Date cardExpire, String cardHolderName, String cardHolderSurname, int cvcCode) {
        this.cardNumber = cardNumber;
        this.cardExpire = cardExpire;
        this.cardHolderName = cardHolderName;
        this.cardHolderSurname = cardHolderSurname;
        this.cvcCode = cvcCode;
    }

    public CreditCard() {
        cardNumber = "";
        cardExpire = Date.from(Instant.now());
        cardHolderName = "";
        cardHolderSurname = "";
        cvcCode = 666;
    }

    public void setCardHolderSurname(String surname) { cardHolderSurname = surname; }

    public void setCardHolderName(String name) { cardHolderName = name; }

    public void setCardExpire(Date cardExpire) { this.cardExpire = cardExpire; }

    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

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
