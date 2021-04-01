package com.example.demo.serverClasses;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void constructor() {
        long transactionId = 666L;
        String transactionType = "0100";//тип запроса 0100
        String transactionSum = "666";
        Instant now = Instant.now();
        Transaction transaction = new Transaction(transactionId, transactionType, transactionSum, now);
    }

}