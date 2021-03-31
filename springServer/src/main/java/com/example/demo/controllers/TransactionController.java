package com.example.demo.controllers;


import com.example.demo.serverClasses.Transaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionController {
    //TODO МБ НУЖНЫ ЕЩЕ ССЫЛКИ, ОБЬЕКТЫ, ТАМ ЮЗЕР, КЛАСТЕР, НЕ ЗНАЮ, ДОБАВЬ ЕСЛИ НАДО
    @GetMapping
    public List<Transaction> getFundraisingTransactionList(){
        //TODO ПОЛУЧАТЬ ВЕСЬ СПИСОК ТРАНЗАКЦИЙ КОНКРЕТНОГО СБОРА
    }
    @GetMapping("{id}")
    public Transaction getTransactionById(@PathVariable String id){
        //TODO ПОЛУЧАТЬ КОНКРЕТНУЮ ТРАНЗАКЦИЮ ПО НОМЕРУ ТРАНЗАКЦИИ
    }
    @PostMapping
    public Transaction createNewTransaction(@RequestBody Transaction transaction){
        //TODO СОЗДАТЬ ТРАНЗАКЦИЮ И ДОБАВИТЬ В БД, ЕСЛИ ОК ВЕРНУТЬ НАЗАД
    }
}
