package com.example.demo.serverClasses;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Transaction {
    private final long transactionId;//номер транзакции именно наш для бд

    private String transactionType = "0100";//тип запроса 0100
    private final String transactionSumm;//сумма транзакции
    private final String transactionCode = "28";//код транзакции всегда 28
    private final Instant transactionTime;//дата и время транзакции
    private String id;

    public long getTransactionId() { return transactionId; }

    public String getTransactionType() { return transactionType; }

    public String getTransactionSumm() { return transactionSumm; }

    public Instant getTransactionTime() { return transactionTime; }

    public Transaction(long transactionId, String transactionType, String transactionSum, Instant transactionTime) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionSumm = transactionSum;
        this.transactionTime = transactionTime;
    }

    public Transaction() {

    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
