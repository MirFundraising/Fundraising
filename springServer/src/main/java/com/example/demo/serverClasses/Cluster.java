package com.example.demo.serverClasses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cluster implements IdGettable {
    protected Cluster() {

    }

    @Override
    public long getId() {
        return 0; //TODO
    }

    @Id
    private long clusterId;
    private String name;
    private int participantCounter;
    private double goal;
    @OneToMany
    private List<User> users;
    @OneToMany
    private List<Fundraising> fundraisings;//список сборов кластера

    public List<Fundraising> getFundraisings() {
        return fundraisings;
    }

    public void setFundraisings(List<Fundraising> fundraisings) {
        this.fundraisings = fundraisings;
    }
    public void addUser(User user) { users.add(user); }

    public String getClusterName() { return name; }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

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

    public Cluster(String name, int participantCounter, double goal, List<User> users) {
        clusterId = getId();
        this.name = name;
        this.participantCounter = participantCounter;
        this.users = users;
    }
}
