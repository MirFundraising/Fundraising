package com.example.demo.serverClasses;

import java.util.Date;

public class Transaction {
    private String transactionType="0100";//тип запроса 0100
    private String transactionId;//номер транзакции
    private String transactionSumm;//сумма транзакции
    private String transactionCode="28";//код транзакции всегда 28
    private Date transactionDate;//дата транзакции
    private Date transactionTime;//время тразакции

    public Transaction(String transactionId,String transactionSumm,Date transactionDate,Date transactionTime,String identifyUserCode) {
        this.transactionId = transactionId;
        this.transactionSumm = transactionSumm;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
    }
}
