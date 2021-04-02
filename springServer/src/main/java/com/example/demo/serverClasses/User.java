/*
package com.example.demo.serverClasses;

import javax.persistence.*;
import java.util.*;

@Entity
public class User implements IdGettable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long memberId; //номер клиента в базе данных

    private final String name;//имя клиента
    private final String surname;//фамилия клиента
    private final String birthdate;//дата рождения
    private final String email;//email
    private final String telephone;//телефонный номер

    @OneToMany
    private final List<Cluster> clusters;
    @ElementCollection
    private final Map<Long, Permission> userPermissionOnClusterId;
    @OneToMany
    private final List<CreditCard> userCards;

    public User() {
        memberId = getId();
        this.name = "";
        this.surname = "";
        this.birthdate = "";
        this.email = "";
        this.telephone = "";
        clusters = new ArrayList<>();
        userCards = new ArrayList<>();
        userPermissionOnClusterId = new HashMap<>();
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void addUserCard(CreditCard card) {
        userCards.add(card);
    }

    public List<CreditCard> getUserCards() {
        return userCards;
    }

    public List<Cluster> getClusters() {
        return clusters;
    }

    public void addCluster(Cluster cluster) {
        clusters.add(cluster);
    }

    public User(String name, String surname, String birthdate,
                String email, String telephone, String password, double balance) {
        memberId = getId();
        if (name.isEmpty() || name == null) {

        }
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.email = email;
        this.telephone = telephone;
        clusters = new ArrayList<>();
        userCards = new ArrayList<>();
        userPermissionOnClusterId = new HashMap<>();
    }

    public void addCardToCluster(Cluster cluster, String cardNumber, String cardHolderSurname,
                                 String cardHolderName, Date cardExpire, int cvcCode) {
        try {
            List<User> users = cluster.getUsers();
            User user = getUser(cluster, cardNumber, cardHolderSurname, cardHolderName, cardExpire, cvcCode);
            if (user == null)
                throw new RuntimeException();
            users.add(user);
            cluster.setUsers(users);
            // TODO сообщение Илье об успешной добавлении
        } catch (RuntimeException e) {
            // TODO сообщение Илье об ошибке
            throw new RuntimeException();
        }
    }

    private User getUser(Cluster cluster, String cardNumber, String cardHolderSurname,
                         String cardHolderName, Date cardExpire, int cvcCode) {
        List<User> users = cluster.getUsers();
        for (int i = 0; i < users.size(); i++) {
            List<CreditCard> cards = users.get(i).getUserCards();
            for (int j = 0; j < cards.size(); j++) {
                if (cards.get(j).getCardNumber() == cardNumber &&
                        cards.get(j).getCardHolderSurname() == cardHolderSurname &&
                        cards.get(j).getCardHolderName() == cardHolderName &&
                        cards.get(j).getCardExpire() == cardExpire &&
                        cards.get(j).getCvcCode() == cvcCode) {
                    return users.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public long getId() {
        return 0;//TODO
    }

}
*/
