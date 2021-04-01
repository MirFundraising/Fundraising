package com.example.demo.controllers;

import com.example.demo.database.DatabaseHandler;
import com.example.demo.serverClasses.CreditCard;
import com.example.demo.serverClasses.User;
import com.sun.xml.bind.v2.TODO;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("card")
public class CardController{
    // в силу того, что БД не до конца реализована, я не могу наладить связь с БД,
    // поэтому написал методы как мог
    DatabaseHandler databaseHandler = new DatabaseHandler();

    @GetMapping
    public List<CreditCard> getUserCardList(@RequestBody User user){
        return user.getUserCards(); //тут должен возвращаться список карт
    }

    @PostMapping
    public CreditCard addNewUserCard(@RequestBody CreditCard creditCard, @RequestBody User user){
        // обработка добавления новой карты в таблицу карт в бд
        List<CreditCard> creditCards = user.getUserCards();
        creditCards.add(creditCard);
        user.addUserCard(creditCard);
        return creditCard;
    }
    @GetMapping("{creditCardNumber}")
    public CreditCard getUserCardById(@PathVariable String creditCardNumber, @RequestBody User user){
        // получать по номеру карты конкретную карту из бд и возвращать ее
        CreditCard card = null;
        List<CreditCard> creditCards = user.getUserCards();
        for (int i = 0; i < creditCards.size(); i++){
            CreditCard card1 = creditCards.get(i);
            if (card1.getCardNumber().equals(creditCardNumber)) {
                card = card1;
                break;
            }
        }
        return card;
    }

}
