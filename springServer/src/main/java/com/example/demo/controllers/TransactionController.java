package com.example.demo.controllers;


import com.example.demo.serverClasses.Fundraising;
import com.example.demo.serverClasses.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    // в силу того, что БД не до конца реализована, я не могу наладить связь с БД,
    // поэтому написал методы как мог
    @GetMapping
    public List<Transaction> getFundraisingTransactionList(@RequestBody Fundraising fundraising) {
        // ПОЛУЧАТЬ ВЕСЬ СПИСОК ТРАНЗАКЦИЙ КОНКРЕТНОГО СБОРА
        return fundraising.getTransactionList();
    }
    @GetMapping("{id}")
    public Transaction getTransactionById(@PathVariable String id, @RequestBody Fundraising fundraising){
        // ПОЛУЧАТЬ КОНКРЕТНУЮ ТРАНЗАКЦИЮ ПО НОМЕРУ ТРАНЗАКЦИИ
        Transaction transaction = null;
        List<Transaction> transactions = fundraising.getTransactionList();
        for (int i = 0; i < transactions.size(); i++) {
            if (String.valueOf(transactions.get(i).getTransactionId()).equals(id)) {
                transaction = transactions.get(i);
                break;
            }
        }
        return transaction;
    }
    @PostMapping
    public Transaction createNewTransaction(@RequestBody Transaction transaction, @RequestBody Fundraising fundraising){
        // СОЗДАТЬ ТРАНЗАКЦИЮ И ДОБАВИТЬ В БД, ЕСЛИ ОК ВЕРНУТЬ НАЗАД
        try {
            List<Transaction> transactions = fundraising.getTransactionList();
            transactions.add(transaction);
            fundraising.setTransactionList(transactions);
            return transaction;
        }
        catch (Exception e) {
            return null;
        }
    }
}
