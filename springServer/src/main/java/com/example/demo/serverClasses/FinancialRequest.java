package com.example.demo.serverClasses;

import java.util.ArrayList;
import java.util.HashMap;

public class FinancialRequest {
    public String operation0200(Cluster cluster) {
        try {
            double count = cluster.getGoal();
            double sum = 0;
            ArrayList<User> allUsers = cluster.getUsers();
            ArrayList<User> admins = new ArrayList();
            ArrayList<User> users = new ArrayList();
            for (int i = 0; i < allUsers.size(); i++) {
                if (getPermission(allUsers.get(i), cluster.getClusterId()).equals("Creator"))
                    admins.add(allUsers.get(i));
                else
                    users.add(allUsers.get(i));
            }

            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getBalance() >= count) {
                    sum += count;
                    users.get(i).setBalance(users.get(i).getBalance() - count);
                } else {
                    sum += users.get(i).getBalance();
                    users.get(i).setBalance(0);
                }
            }
            double num = sum / admins.size();
            for (int i = 0; i < admins.size(); i++) {
                admins.get(i).setBalance(admins.get(i).getBalance() + num);
            }
            return "Operation was successful";
        }
        catch (Exception e) {
            return "Error! " + e.getMessage();
        }
    }

    public String getPermission(User user, long clusterId) {
        var info = user.getUserPermissionOnClusterId();
        String ans = "Nothing";
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
        }
        return ans;
    }

}
