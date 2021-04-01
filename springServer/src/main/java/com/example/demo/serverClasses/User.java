package com.example.demo.serverClasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
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
    private ArrayList<Cluster> clusters;
    private HashMap<Long, Permission> userPermissionOnClusterId;
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

    public String getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void addUserCard(CreditCard card){
        userCards.add(card);
    }

    public ArrayList<CreditCard> getUserCards() { return userCards; }

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
    }

    public void addCardToCluster(Cluster cluster, String cardNumber, String cardHolderSurname,
                    String cardHolderName, Date cardExpire, int cvcCode) {
        try {
            ArrayList<User> users = cluster.getUsers();
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
        ArrayList<User> users = cluster.getUsers();
        for (int i = 0; i < users.size(); i++) {
            ArrayList<CreditCard> cards = users.get(i).getUserCards();
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
