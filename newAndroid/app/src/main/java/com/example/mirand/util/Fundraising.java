package com.example.mirand.util;

import java.util.ArrayList;
import java.util.Calendar;

public class Fundraising {
    private double goal;//сумма цели сбора
    private boolean isGoalAllowed;//есть ли цель
    private String fundraisingName;//название сбора
    private Calendar fundraisingExpire;//дата окончания сбора
    private ArrayList<Transaction> transactionList=new ArrayList<>();//список перечисленных денег
    private final double currentFundSum;//текущий сбор

    public Fundraising(double goal, boolean isGoalAllowed, String fundraisingName, Calendar fundraisingExpire, double currentFundSum) {
        this.goal = goal;
        this.isGoalAllowed = isGoalAllowed;
        this.fundraisingName = fundraisingName;
        this.fundraisingExpire = fundraisingExpire;
        this.currentFundSum = currentFundSum;
    }

    public double getGoal() {
        return goal;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }

    public boolean isGoalAllowed() {
        return isGoalAllowed;
    }

    public void setGoalAllowed(boolean goalAllowed) {
        isGoalAllowed = goalAllowed;
    }

    public String getFundraisingName() {
        return fundraisingName;
    }

    public void setFundraisingName(String fundraisingName) {
        this.fundraisingName = fundraisingName;
    }

    public Calendar getFundraisingExpire() {
        return fundraisingExpire;
    }

    public void setFundraisingExpire(Calendar fundraisingExpire) {
        this.fundraisingExpire = fundraisingExpire;
    }

    public ArrayList<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(ArrayList<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public double getCurrentFundSum() {
        return currentFundSum;
    }
}
