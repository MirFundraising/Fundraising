package com.example.demo.serverClasses;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;

@Entity
public class User implements IdGettable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId; //номер клиента в базе данных

    private String name;//имя клиента
    private String surname;//фамилия клиента
    private String birthDate;//дата рождения
    private String email;//email
    private String telephoneNumber;//телефонный номер
    private Double balance;// баланс пользователя
    private String password;
    private ArrayList<Cluster> clusters;
    private HashMap<Long, Permission> userPermissionOnClusterId;

    public Long getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User(String name, String surname, String birthDate,
                String email, String telephoneNumber, String password, double balance) {
        memberId = getId();
        if (name.isEmpty() || name == null) {

        }
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.password = password;
        this.balance = balance;
    }

    @Override
    public long getId() {
        return 0;//TODO
    }

}
