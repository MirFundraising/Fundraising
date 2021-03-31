package com.example.demo.serverClasses;

import java.util.ArrayList;
import java.util.Calendar;

public class Fundraising {
    private long fundraisingId;//Для бд

    private double goal;//сумма цели сбора
    private boolean isGoalAllowed;//есть ли цель
    private String fundraisingName;//название сбора
    private Calendar fundraisingExpire;//дата окончания сбора
    private ArrayList<Integer> transactionList;//список транзакций
    private double currentFundSumm;//текущий сбор

    public Fundraising(long fundraisingId,double goal,boolean isGoalAllowed,String fundraisingName,Calendar fundraisingExpire,ArrayList<Integer> transactionList,double currentFundSumm) {
        this.fundraisingId = fundraisingId;
        this.goal = goal;
        this.isGoalAllowed = isGoalAllowed;
        this.fundraisingName = fundraisingName;
        this.fundraisingExpire = fundraisingExpire;
        this.transactionList = transactionList;
        this.currentFundSumm = currentFundSumm;
    }
}
