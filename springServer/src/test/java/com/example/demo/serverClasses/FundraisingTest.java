package com.example.demo.serverClasses;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FundraisingTest {

    private final long fundraisingId = 666L;
    private final double goal = 6.66;
    private final boolean isGoalAllowed = false;
    private final String fundraisingName = "name";
    private final Calendar fundraisingExpire = Calendar.getInstance();
    private final List<Transaction> transactionList = new ArrayList<>();
    private final double currentFundSum = 66.6;


    Fundraising fundraising = new Fundraising(fundraisingId, goal, isGoalAllowed,
            fundraisingName, fundraisingExpire, transactionList, currentFundSum);

    @Test
    void getFundraisingId() {
        assertEquals(fundraising.getFundraisingId(), fundraisingId);
    }

    @Test
    void getTransactionList() {
        assertEquals(fundraising.getTransactionList(), new ArrayList<>());
    }

    @Test
    void getFundraisingName() {
        assertEquals(fundraising.getFundraisingName(), fundraisingName);
    }

    @Test
    void getFundraisingExpire() {
        assertEquals(fundraising.getFundraisingExpire(), fundraisingExpire);
    }

    @Test
    void getGoal() {
        assertEquals(fundraising.getGoal(), goal);
    }

    @Test
    void getCurrentFundSum() {
        assertEquals(fundraising.getCurrentFundSum(), currentFundSum);
    }

    @Test
    void isGoalAllowed() {
        assertEquals(fundraising.isGoalAllowed(), isGoalAllowed);
    }

    private final long transactionId = 666L;
    private final String transactionType = "0100";//тип запроса 0100
    private final String transactionSum = "666";
    private final Instant now = Instant.now();
    private final Transaction transaction = new Transaction(transactionId, transactionType, transactionSum, now);

    @Test
    void setAndGetTransactionList() {
        List<Transaction> list = new ArrayList<>();
        list.add(transaction);
        fundraising.setTransactionList(list);
        assertEquals(fundraising.getTransactionList(), list);
    }

}