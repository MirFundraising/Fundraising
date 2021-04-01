package com.example.demo.serverClasses;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClusterTest {

    private static final String userName = "MyName";
    private static final String userSurname = "MySurname";
    private static final String userBirthDate = "2020-02-02";
    private static final String userEmail = "mail@xxx.com";
    private static final String userTelephoneNumber = "88005553535";
    private static final User user = new User(userName, userSurname, userBirthDate, userEmail, userTelephoneNumber, "password", 0);

    private static final String name = "name";
    private static final int participantCounter = 666;
    private static final double goal = 6.66;
    private static final List<User> users = new ArrayList<>();
    private static final Cluster cluster;
    static {
        users.add(user);
        cluster = new Cluster(name, participantCounter, goal, users);
    }

    @Test
    void getId() {
        assertEquals(cluster.getId(), 0L); // TODO нет метода
    }

    @Test
    void getAndSetFundraisings() {
        long fundraisingId = 666L;
        Fundraising fundraising = new Fundraising(fundraisingId, 0, false, "", Calendar.getInstance(), new ArrayList<>(), 0);
        List<Fundraising> list = new ArrayList<>();
        list.add(fundraising);
        cluster.setFundraisings(list);
        assertEquals(cluster.getFundraisings(), list);
    }

    @Test
    void getAndSetUsers() {
        User user1 = new User();
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        cluster.setUsers(list);
        assertEquals(cluster.getUsers(), list);
    }

    @Test
    void getParticipantCounter() {
        assertEquals(cluster.getParticipantCounter(), participantCounter);
    }

    @Test
    void setParticipantCounter() {
        int participantCounter1 = 999;
        cluster.setParticipantCounter(participantCounter1);
        assertEquals(cluster.getParticipantCounter(), participantCounter1);
        cluster.setParticipantCounter(participantCounter);
    }

    @Test
    void getGoal() {
        assertEquals(cluster.getGoal(), goal);
    }

    @Test
    void setGoal() {
        double goal1 = 9.99;
        cluster.setGoal(goal1);
        assertEquals(cluster.getGoal(), goal1);
        cluster.setGoal(goal);
    }

    @Test
    void getName() {
        assertEquals(cluster.getName(), name);
    }

    @Test
    void setName() {
        String name2 = "name2";
        cluster.setName(name2);
        assertEquals(cluster.getName(), name2);
        cluster.setName(name);
    }

    @Test
    void getClusterId() {
        assertEquals(cluster.getClusterId(), 0); // TODO не сделан getId
    }

    @Test
    void setClusterId() {
        long clusterId2 = 999L;
        cluster.setClusterId(clusterId2);
        assertEquals(cluster.getClusterId(), clusterId2);
        cluster.setClusterId(cluster.getId());

    }
}