package com.example.demo.serverClasses;

import java.util.HashMap;

public class FinancialRequestResponse {
    public String operation0210(User user, double coin, long clusterId) {
        if (coin >= 0 && getPermission(user, clusterId).equals("Creator"))
            return "Пополнение " + coin + " руб. Баланс: " + user.getBalance();
        else if (coin >= 0 && (getPermission(user, clusterId).equals("Common") ||
                getPermission(user, clusterId).equals("Administrator")))
            return "Оплата прошла успешно! Списание " + coin + "руб. Баланс: " + user.getBalance();
        return "Ошибка системы, оплата не произведена! Баланс: " + user.getBalance();
    }

    private String getPermission(User user, long clusterId) {
        HashMap<Long, Permission> info = user.getUserPermissionOnClusterId();
        String ans;
        switch (info.get(clusterId)) {
            case Common:
                ans = "Common";
                break;
            case Creator:
                ans = "Creator";
                break;
            case Administrator:
                ans = "Administrator";
                break;
            default:
                ans = "Nothing";
                break;
        }
        return ans;
    }
}
