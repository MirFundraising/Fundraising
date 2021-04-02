package com.example.demo.controllers;

import com.example.demo.database.DatabaseHandler;
import com.example.demo.serverClasses.CreditCard;
import com.example.demo.serverClasses.User;
import com.sun.xml.bind.v2.TODO;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("card")
public class CardController{
    DatabaseHandler databaseHandler = new DatabaseHandler();

    @GetMapping
    public List<CreditCard> getUserCardList(@RequestBody User user){
        return user.getUserCards(); //тут должен возвращаться список карт
    }

    @PostMapping
    public CreditCard addNewUserCard(@RequestBody CreditCard creditCard){
        // обработка добавления новой карты в таблицу карт в бд
        try {
            databaseHandler.createCreditCard(creditCard);
            return creditCard;
        }
        catch (Exception e) {
            return null;
        }
    }
    @GetMapping("{creditCardNumber}")
    public CreditCard getUserCardById(@PathVariable String creditCardNumber/*, @RequestBody User user*/) throws SQLException {
        // получать по номеру карты конкретную карту из бд и возвращать ее
        CreditCard card = null;
        ResultSet rs = databaseHandler.getCreditCard(creditCardNumber);
        int columns = rs.getMetaData().getColumnCount();
        try {
            while(rs.next()) {
                CreditCard card1 = new CreditCard();
                card1.setCardNumber(rs.getString(1));
                SimpleDateFormat format = new SimpleDateFormat();
                Date date = format.parse(rs.getString(2));
                card1.setCardExpire(date);
                card1.setCardHolderName(rs.getString(3));
                card1.setCardHolderName(rs.getString(4));
                card = card1;
            }
            return card;
        }
        catch (SQLException | ParseException e) {
            return card;
        }

        /*
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
         */
    }
}
