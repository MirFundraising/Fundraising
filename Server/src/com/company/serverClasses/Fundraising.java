package com.company.serverClasses;

import java.util.ArrayList;
import java.util.Calendar;

public class Fundraising {
    double goal;//сумма цели сбора
    boolean isGoalAllowed;//есть ли цель
    String fundraisingName;//название сбора
    int databaseId;//id для базы данных
    Calendar fundraisingExpire;//дата окончания сбора
    ArrayList<Integer> transactionList;//список перечисленных денег
}
