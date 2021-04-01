package com.example.demo.serverClasses;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Fundraising {
    @Id
    private long fundraisingId;//Для бд

    private double goal;//сумма цели сбора
    private boolean isGoalAllowed;//есть ли цель
    private String fundraisingName;//название сбора
    private Calendar fundraisingExpire;//дата окончания сбора
    @ElementCollection
    private List<Integer> transactionList;//список транзакций
    private double currentFundSumm;//текущий сбор

    public long getFundraisingId () {
        return fundraisingId;
    }

    public Fundraising(long fundraisingId,double goal,boolean isGoalAllowed,String fundraisingName,Calendar fundraisingExpire,ArrayList<Integer> transactionList,double currentFundSumm) {
        this.fundraisingId = fundraisingId;
        this.goal = goal;
        this.isGoalAllowed = isGoalAllowed;
        this.fundraisingName = fundraisingName;
        this.fundraisingExpire = fundraisingExpire;
        this.transactionList = transactionList;
        this.currentFundSumm = currentFundSumm;
    }

    protected Fundraising() {

    }
}
