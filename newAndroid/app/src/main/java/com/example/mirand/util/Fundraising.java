package com.example.mirand.util;

import java.util.ArrayList;
import java.util.Calendar;

public class Fundraising {
    double goal;//сумма цели сбора
    boolean isGoalAllowed;//есть ли цель
    String fundraisingName;//название сбора
    Calendar fundraisingExpire;//дата окончания сбора
    ArrayList<Transaction> transactionList=new ArrayList<>();//список перечисленных денег
    public Fundraising(double goal, boolean isGoalAllowed, String fundraisingName, Calendar fundraisingExpire) {
        this.goal = goal;
        this.isGoalAllowed = isGoalAllowed;
        this.fundraisingName = fundraisingName;
        this.fundraisingExpire = fundraisingExpire;
    }

    public double getGoal() {
        return goal;
    }

    public boolean isGoalAllowed() {
        return isGoalAllowed;
    }

    public String getFundraisingName() {
        return fundraisingName;
    }

    public Calendar getFundraisingExpire() {
        return fundraisingExpire;
    }
}
