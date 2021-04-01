package com.example.demo.serverClasses;

import java.time.Instant;

public class Transaction {
    private final long transactionId;//номер транзакции именно наш для бд

    private String transactionType = "0100";//тип запроса 0100
    private final String transactionSum;//сумма транзакции
    private final String transactionCode = "28";//код транзакции всегда 28
    private final Instant transactionTime;//дата и время транзакции

    public Transaction(long transactionId, String transactionType, String transactionSum, Instant transactionTime) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionSum = transactionSum;
        this.transactionTime = transactionTime;
    }
}
