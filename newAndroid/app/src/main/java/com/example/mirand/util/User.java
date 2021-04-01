package com.example.mirand.util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private Long memberId=0L; //номер клиента в базе данных

    private String name;//имя клиента
    private String surname;//фамилия клиента
    private java.sql.Date birthDate;//дата рождения
    private String email;//email
    private String telephoneNumber;//телефонный номер
    private Double balance=0.0;// баланс пользователя
    private ArrayList<Cluster> clusters=new ArrayList<>();
    private HashMap<Long, Permission> userPermissionOnClusterId=new HashMap<>();
    private ArrayList<CreditCard> userCards=new ArrayList<>();

    public Long getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public ArrayList<Cluster> getClusters() {
        return clusters;
    }

    public HashMap<Long, Permission> getUserPermissionOnClusterId() {
        return userPermissionOnClusterId;
    }
    public void addClusters(Cluster cluster){
        clusters.add(cluster);
    }
    public void addUserCard(CreditCard card){
        userCards.add(card);
    }

    public ArrayList<CreditCard> getUserCards() {
        return userCards;
    }

    public User(String name, String surname, java.sql.Date birthDate, String email, String telephoneNumber) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
    }
}
