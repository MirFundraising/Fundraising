package com.example.demo.controllers;

import com.example.demo.database.DatabaseHandler;
import com.example.demo.serverClasses.CreditCard;
import com.sun.xml.bind.v2.TODO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("card")
public class CardController {
    //TODO МБ НУЖНЫ ЕЩЕ ССЫЛКИ, ОБЬЕКТЫ, ТАМ ЮЗЕР, КЛАСТЕР, НЕ ЗНАЮ, ДОБАВЬ ЕСЛИ НАДО
    DatabaseHandler databaseHandler=new DatabaseHandler();

    @GetMapping
    public List<CreditCard> getUserCardList(){
        //TODO
        return null;//тут должен возвращаться список карт
    }

    @PostMapping
    public CreditCard addNewUserCard(@RequestBody CreditCard creditCard){
        //TODO обработка добавления новой карты в таблицу карт в бд
        return creditCard;
    }
    @GetMapping("{id}")
    public CreditCard getUserCardById(@PathVariable String creditCardNumber){
        //TODO получать по номеру карты конкретную карту из бд и возвращать ее
    }

}
