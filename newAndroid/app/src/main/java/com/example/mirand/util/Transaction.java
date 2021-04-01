package com.example.mirand.util;

import java.util.Date;

public class Transaction {
    private long transactionId;//номер транзакции именно наш для бд

    private String transactionType="0100";//тип запроса 0100
    private String transactionSumm;//сумма транзакции
    private String transactionCode="28";//код транзакции всегда 28
    private Date transactionDate;//дата транзакции
    private Date transactionTime;//время тразакции

    public Transaction(long transactionId,String transactionType,String transactionSumm,Date transactionDate,Date transactionTime) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.transactionSumm = transactionSumm;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
    }
}
