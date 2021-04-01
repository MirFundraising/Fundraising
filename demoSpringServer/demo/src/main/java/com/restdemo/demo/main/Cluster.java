package com.restdemo.demo.main;


import java.util.ArrayList;

public class Cluster implements IdGettable {
    @Override
    public long getId() {
        return 0; //TODO
    }

    private long clusterId;
    private String name;
    private int participantCounter;
    private double goal;
    private ArrayList<User> users;
    private ArrayList<Fundraising> fundraisings;//список сборов кластера

    public ArrayList<User> getUsers() {
        return users;
    }
    public void setUsers(ArrayList<User> users) { this.users = users; }

    public int getParticipantCounter() {
        return participantCounter;
    }

    public void setParticipantCounter(int participantCounter) {
        this.participantCounter = participantCounter;
    }

    public double getGoal() {
        return goal;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getClusterId() {
        return clusterId;
    }

    public void setClusterId(long clusterId) {
        this.clusterId = clusterId;
    }

    public Cluster(String name, int participantCounter, double goal, ArrayList<User> users) {
        clusterId = getId();
        this.name = name;
        this.participantCounter = participantCounter;
        this.users = users;
    }
}
