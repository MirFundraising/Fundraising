package com.example.demo.serverClasses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private final String name = "MyName";
    private final String surname = "MySurname";
    private final String birthDate = "2020-02-02";
    private final String email = "mail@xxx.com";
    private final String telephoneNumber = "88005553535";

    private final User user = new User(name, surname, birthDate, email, telephoneNumber, "password", 0);

    @Test
    void getMemberId() {
        assertEquals(user.getMemberId(), 0); //TODO
    }

    @Test
    void getName() {
        assertEquals(user.getName(), name);
    }

    @Test
    void getSurname() {
        assertEquals(user.getSurname(), surname);
    }

    @Test
    void getBirthDate() {
        assertEquals(user.getBirthDate(), birthDate);
    }

    @Test
    void getEmail() {
        assertEquals(user.getEmail(), email);
    }

    @Test
    void getTelephoneNumber() {
        assertEquals(user.getTelephoneNumber(), telephoneNumber);
    }

    @Test
    void addUserCard() {
    }

    @Test
    void getUserCards() {
    }

    @Test
    void addCardToCluster() {
    }

    @Test
    void getId() {
    }
}