package com.example.demo.serverClasses;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Transaction {
    @Id
    private long transactionId;//номер транзакции именно наш для бд

    private String transactionType = "0100";//тип запроса 0100
    private String transactionSum;//сумма транзакции
    private final String transactionCode = "28";//код транзакции всегда 28
    private Instant transactionTime;//дата и время транзакции

    public long getTransactionId() {
        return transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getTransactionSum() {
        return transactionSum;
    }

    public Instant getTransactionTime() {
        return transactionTime;
    }

    private void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    private void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    private void setTransactionSum(String transactionSum) {
        this.transactionSum = transactionSum;
    }

    private void setTransactionTime(Instant transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Transaction(long transactionId, String transactionType, String transactionSum, Instant transactionTime) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionSum = transactionSum;
        this.transactionTime = transactionTime;
    }

    public Transaction() {

    }
}
