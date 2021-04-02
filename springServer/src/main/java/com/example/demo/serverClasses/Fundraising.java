/*
package com.example.demo.serverClasses;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
public class Fundraising {
    @Id
    private final long fundraisingId;//Для бд

    private final double goal;//сумма цели сбора
    private final boolean isGoalAllowed;//есть ли цель
    private final String fundraisingName;//название сбора
    private final Calendar fundraisingExpire;//дата окончания сбора
    private final double currentFundSum;//текущий сбор
    @OneToMany
    private List<Transaction> transactionList;//список транзакций

    public String getFundraisingName() { return fundraisingName; }

    public Calendar getFundraisingExpire() { return fundraisingExpire; }

    public double getGoal() { return goal; }

    public double getCurrentFundSum() { return currentFundSum; }

    public boolean isGoalAllowed() { return isGoalAllowed;}

    public void setTransactionList(List<Transaction> transactions) {
        transactionList = transactions;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public long getFundraisingId() {
        return fundraisingId;
    }

    public Fundraising(long fundraisingId, double goal, boolean isGoalAllowed, String fundraisingName,
                       Calendar fundraisingExpire, List<Transaction> transactionList, double currentFundSum) {
        this.fundraisingId = fundraisingId;
        this.goal = goal;
        this.isGoalAllowed = isGoalAllowed;
        this.fundraisingName = fundraisingName;
        this.fundraisingExpire = fundraisingExpire;
        this.transactionList = transactionList;
        this.currentFundSum = currentFundSum;
    }

    protected Fundraising() {
        this.fundraisingId = 0;
        this.goal = 0.;
        this.isGoalAllowed = false;
        this.fundraisingName = "fundraisingName";
        this.fundraisingExpire = Calendar.getInstance();
        this.transactionList = new ArrayList<>();
        this.currentFundSum = 0.;
    }
}
*/
