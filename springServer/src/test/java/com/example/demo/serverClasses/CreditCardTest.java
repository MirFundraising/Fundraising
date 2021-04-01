package com.example.demo.serverClasses;

import org.junit.jupiter.api.Test;

import java.time.Instant;
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
    void getCardNumber() {
        assertEquals(card.getCardNumber(), cardNumber);
    }

    @Test
    void getCardExpire() {
        assertEquals(card.getCardExpire(), cardDate);
    }

    @Test
    void getCardHolderName() {
        assertEquals(card.getCardHolderName(), cardName);
    }

    @Test
    void getCardHolderSurname() {
        assertEquals(card.getCardHolderSurname(), cardSurname);
    }

    @Test
    void getCvcCode() {
        assertEquals(card.getCvcCode(), cardCvcCode);
    }
}