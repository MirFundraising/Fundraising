package com.company.serverClasses;

import java.util.ArrayList;

public class Cluster implements IdGettable{
    @Override
    public long getId() {
        return 0; //TODO
    }
    private long clusterId;
    private String clusterName;
    private int participantCounter;
    private ArrayList<User> users;
    private ArrayList<Fundraising> fundraisings;//список сборов кластера
    public ArrayList<User> getUsers() {
        return users;
    }

    public Cluster(String clusterName, int participantCounter, double goal, ArrayList<User> users) {
        clusterId=getId();
        this.clusterName = clusterName;
        this.participantCounter = participantCounter;
        this.users = users;
    }
}
