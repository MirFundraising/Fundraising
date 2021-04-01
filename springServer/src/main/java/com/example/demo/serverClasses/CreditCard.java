package com.example.demo.serverClasses;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@Entity
public class CreditCard {
    @Id
    private long cardId;
    private final String cardNumber;
    private final Date cardExpire;
    private final String cardHolderName;
    private final String cardHolderSurname;
    private final int cvcCode;

    public CreditCard(String cardNumber, Date cardExpire, String cardHolderName, String cardHolderSurname, int cvcCode) {
        this.cardNumber = cardNumber;
        this.cardExpire = cardExpire;
        this.cardHolderName = cardHolderName;
        this.cardHolderSurname = cardHolderSurname;
        this.cvcCode = cvcCode;
    }

    protected CreditCard() {
        cardNumber = "";
        cardExpire = Date.from(Instant.now());
        cardHolderName = "";
        cardHolderSurname = "";
        cvcCode = 666;
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
