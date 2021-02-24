package com.company.serverClasses;

import java.util.ArrayList;

public class FinancialRequest{
    public void operation0200(Cluster cluster) {
        double count = cluster.getGoal();
        double sum = 0;
        ArrayList<User> allUsers = cluster.getUsers();
        ArrayList<User> admins = new ArrayList();
        ArrayList<User> users = new ArrayList();
        for (int i = 0; i < allUsers.size(); i++) {
            //if (users.get(i).getId()) // если админ или создатель
                admins.add(allUsers.get(i));
            //else
                users.add(allUsers.get(i));
        }

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getBalance() >= count) {
                sum += count;
                users.get(i).setBalance(users.get(i).getBalance() - count);
            }
            else {
                sum += users.get(i).getBalance();
                users.get(i).setBalance(0);
            }
        }
        double num = sum / admins.size();
        for (int i = 0; i < admins.size(); i++) {
            admins.get(i).setBalance(admins.get(i).getBalance() + num);
        }
    }
}
