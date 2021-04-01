package com.example.demo.serverClasses;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    private final long transactionId = 666L;
    private final String transactionType = "0100";//тип запроса 0100
    private final String transactionSum = "666";
    private final Instant now = Instant.now();
    private final Transaction transaction = new Transaction(transactionId, transactionType, transactionSum, now);
    private final String id = "ID";

    @Test
    void getTransactionId() {
        assertEquals(transaction.getTransactionId(), transactionId);
    }

    @Test
    void getTransactionType() {
        assertEquals(transaction.getTransactionType(), transactionType);
    }

    @Test
    void getTransactionSum() {
        assertEquals(transaction.getTransactionSum(), transactionSum);
    }

    @Test
    void getTransactionTime() {
        assertEquals(transaction.getTransactionTime(), now);
    }

    @Test
    void setAndGetId() {
        transaction.setId(id);
        assertEquals(transaction.getId(), id);
    }
}