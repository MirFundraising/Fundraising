package com.example.mirand.util;

import java.util.ArrayList;

public class Cluster {
    //private long clusterId;
    private String name;
    private int participantCounter;
    private ArrayList<User> users;
    private ArrayList<Fundraising> fundraisings=new ArrayList<>();//список сборов кластера

 // public long getClusterId() {
 //     return clusterId;
 // }

    public String getName() {
        return name;
    }

    public int getParticipantCounter() {
        return participantCounter;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
    public void addFundraising(Fundraising fundraising){
        fundraisings.add(fundraising);
    }

    public ArrayList<Fundraising> getFundraisings() {
        return fundraisings;
    }

    public Cluster(String name, int participantCounter,ArrayList<User> users) {
       // this.clusterId = clusterId;
        this.name = name;
        this.participantCounter = participantCounter;
        this.users = users;
    }
}
