package com.example.demo.serverClasses;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreditCardTest {

    private final String cardName = "MyName";
    private final String cardSurname = "MySurname";
    private final String cardNumber = "666";
    private final int cardCvcCode = 666;
    private final Date cardDate = Date.from(Instant.now());
    private final CreditCard card = new CreditCard(cardNumber, cardDate, cardName, cardSurname, cardCvcCode);

    @Test
    void getAndSetCardNumber() {
        String cardNumber1 = cardNumber + "1";
        card.setCardNumber(cardNumber1);
        assertEquals(card.getCardNumber(), cardNumber1);
    }

    @Test
    void getAndSetCardExpire() {
        Date cardExpire1 = Date.from(Instant.now());
        card.setCardExpire(cardExpire1);
        assertEquals(card.getCardExpire(), cardExpire1);
    }

    @Test
    void getAndSetCardHolderName() {
        String cardName1 = cardName + "1";
        card.setCardHolderName(cardName1);
        assertEquals(card.getCardHolderName(), cardName1);
    }

    @Test
    void getAndSetCardHolderSurname() {
        String cardSurname1 = cardSurname + "1";
        card.setCardHolderName(cardSurname1);
        assertEquals(card.getCardHolderName(), cardSurname1);
    }

    @Test
    void getCvcCode() {
        assertEquals(card.getCvcCode(), cardCvcCode);
    }
}