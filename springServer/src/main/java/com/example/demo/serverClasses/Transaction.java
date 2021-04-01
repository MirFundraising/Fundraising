package com.example.demo.serverClasses;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    private long transactionId;//номер транзакции именно наш для бд

    private String transactionType="0100";//тип запроса 0100
    private String transactionSumm;//сумма транзакции
    private String transactionCode="28";//код транзакции всегда 28
    private Date transactionDate;//дата транзакции
    private Date transactionTime;//время тразакции
    private String id;

    public long getTransactionId() { return transactionId; }

    public String getTransactionType() { return transactionType; }

    public String getTransactionSumm() { return transactionSumm; }

    public Date getTransactionDate() { return transactionDate; }

    public Date getTransactionTime() { return transactionTime; }

    public Transaction(long transactionId,String transactionType,String transactionSumm,Date transactionDate,Date transactionTime) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionSumm = transactionSumm;
        this.transactionDate = transactionDate;
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
