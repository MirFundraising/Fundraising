package com.example.demo.controllers;

import com.example.demo.database.DatabaseHandler;
import com.example.demo.serverClasses.CreditCard;
import com.example.demo.serverClasses.User;
import com.sun.xml.bind.v2.TODO;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("card")
public class CardController{
    // МБ НУЖНЫ ЕЩЕ ССЫЛКИ, ОБЬЕКТЫ, ТАМ ЮЗЕР, КЛАСТЕР, НЕ ЗНАЮ, ДОБАВЬ ЕСЛИ НАДО
    DatabaseHandler databaseHandler = new DatabaseHandler();

    @GetMapping
    public List<CreditCard> getUserCardList(@RequestBody User user){
        return user.getUserCards(); //тут должен возвращаться список карт
    }

    @PostMapping
    public CreditCard addNewUserCard(@RequestBody User user, @RequestBody CreditCard creditCard){
        // обработка добавления новой карты в таблицу карт в бд
        List<CreditCard> creditCards = user.getUserCards();
        creditCards.add(creditCard);
        user.addUserCard(creditCard);
        return creditCard;
    }
    @GetMapping("{id}")
    public CreditCard getUserCardById(@RequestBody User user, @PathVariable String creditCardNumber){
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
