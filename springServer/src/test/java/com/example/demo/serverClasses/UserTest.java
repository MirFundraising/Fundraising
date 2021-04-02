//package com.example.demo.serverClasses;
//
//import org.junit.jupiter.api.Test;
//
//import java.time.Instant;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class UserTest {
//
//    private final String userName = "MyName";
//    private final String userSurname = "MySurname";
//    private final String userBirthDate = "2020-02-02";
//    private final String userEmail = "mail@xxx.com";
//    private final String userTelephoneNumber = "88005553535";
//    private final User user = new User(userName, userSurname, userBirthDate, userEmail, userTelephoneNumber, "password", 0);
//
//    private final String cardNumber = "666";
//    private final int cardCvcCode = 666;
//    private final CreditCard card = new CreditCard(cardNumber, Date.from(Instant.now()), userName, userSurname, cardCvcCode);
//
//    @Test
//    void getMemberId() {
//        assertEquals(user.getMemberId(), 0); //TODO нет MemberId
//    }
//
//    @Test
//    void getName() {
//        assertEquals(user.getName(), userName);
//    }
//
//    @Test
//    void getSurname() {
//        assertEquals(user.getSurname(), userSurname);
//    }
//
//    @Test
//    void getBirthDate() {
//        assertEquals(user.getBirthdate(), userBirthDate);
//    }
//
//    @Test
//    void getEmail() {
//        assertEquals(user.getEmail(), userEmail);
//    }
//
//    @Test
//    void getTelephoneNumber() {
//        assertEquals(user.getTelephone(), userTelephoneNumber);
//    }
//
//    @Test
//    void addUserCard() {
//        user.addUserCard(card);
//        List<CreditCard> cards = user.getUserCards();
//        assertEquals(cards.get(cards.size() - 1), card);
//    }
//
//    @Test
//    void getUserCards() {
//        user.addUserCard(card);
//        List<CreditCard> cards = new ArrayList<>();
//        cards.add(card);
//        assertEquals(cards, user.getUserCards());
//    }
//
//    @Test
//    void addCardToCluster() {
//        //TODO
//    }
//
//    @Test
//    void getId() {
//        assertEquals(0, user.getId()); //TODO нет ID
//    }
//}