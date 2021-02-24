package com.company.serverClasses;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class User implements IdGettable {
    private long memberId; //номер клиента в базе данных
    private String name;//имя клиента
    private String surname;//фамилия клиента
    private Date birthDate;//дата рождения
    private String email;//email
    private String telephoneNumber;//телефонный номер
    private int balance;// баланс пользователя
    private String password;
    private ArrayList<Cluster> clusters;
    private HashMap<Long,Permission> userPermissionOnClusterId;

    public long getMemberId() {
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

    public int getBalance() { return balance; }

    public User(String name, String surname, Date birthDate, String email, String telephoneNumber, String password, int balance) {
        memberId=getId();
        if (name.isEmpty()||name==null){

        }
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.password=password;
        this.balance = balance;
    }

    @Override
    public long getId() {
        return 0;//TODO
    }
}

