package com.company.serverClasses;

public class FinancialRequestResponse {
    public String operation0210 (User user, double coin) {
        if (coin >= 0 && true) // юзер = админ или создатель
            return "Пополнение " + coin + " руб. Баланс: " + user.getBalance();
        else if (coin >= 0 && true) // юзер = пользователь
            return "Оплата прошла успешно! Списание " + coin + "руб. Баланс: " + user.getBalance();
        return "Ошибка системы, оплата не произведена! Баланс: " + user.getBalance();
    }
}
