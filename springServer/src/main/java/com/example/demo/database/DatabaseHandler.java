package com.example.demo.database;


import com.example.demo.serverClasses.*;

import java.sql.*;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    // Подключение к базе данных
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
/*
    // Добавление в базу данных user'a
    public void signUpUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_NAME + "," + Const.USER_SURNAME + "," +
                Const.USER_EMAIL + "," + Const.USER_BIRTHDATE + *//*"," + Const.USER_BALANCE + "," + Const.USER_PHONE +*//* ")" +
                "VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getBirthdate());
//            preparedStatement.setString(5, balance);
//            preparedStatement.setString(6, phone);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createCluster(Cluster cluster) {
        String insert = "INSERT INTO" + Const.CLUSTER_TABLE + "(" + Const.CLUSTER_NAME + "," +
                Const.CLUSTER_PARTICIPANT_COUNTER + "," + Const.CLUSTER_GOAL + ")" + "VALUES(?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, cluster.getName());
            preparedStatement.setString(2, String.valueOf(cluster.getParticipantCounter()));
            preparedStatement.setString(3, String.valueOf(cluster.getGoal()));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getUser(User user) {
        ResultSet rs = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_EMAIL + "=? AND " + Const.USER_PHONE + "=?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getTelephone());
            rs = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return  rs;
    }

    public ResultSet getCluster(Cluster cluster) {
        ResultSet rs = null;

        String select = "SELECT * FROM " + Const.CLUSTER_TABLE + " WHERE " +
                Const.CLUSTER_NAME + "=?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, cluster.getClusterName());
            rs = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return  rs;
    }
*/
    public void createCreditCard(CreditCard creditCard) {
        String insert = "INSERT INTO " + Const.CARD_TABLE + " (" + Const.CARD_NUMBER + "," +
                Const.CARD_EXPIRE + "," + Const.CARD_HOLDER_NAME + "," + Const.CARD_HOLDER_SURNAME + "," + Const.CARD_CVC + ")" +
                " VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, creditCard.getCardNumber());
            preparedStatement.setString(2, String.valueOf(creditCard.getCardExpire()));
            preparedStatement.setString(3, creditCard.getCardHolderName());
            preparedStatement.setString(4, creditCard.getCardHolderSurname());
            preparedStatement.setInt(5, creditCard.getCvcCode());
            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getCreditCard(String cardNumber) {
        ResultSet rs = null;

        String select = "SELECT * FROM " + Const.CARD_TABLE + " WHERE " +
                Const.CARD_NUMBER + "=?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, cardNumber);
            rs = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return  rs;
    }
/*
    public void createFundraising(Fundraising fundraising) {
        String insert = "INSERT INTO" + Const.FUNDRAISING_TABLE + "(" + Const.FUNDRAISING_NAME + "," +
                Const.FUNDRAISING_EXPIRE + "," + Const.FUNDRAISING_GOAL + "," +
                Const.FUNDRAISING_Goal_Allowed + "," +
                Const.FUNDRAISING_FUND_SUM + ")" + "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, fundraising.getFundraisingName());
            preparedStatement.setString(2, String.valueOf(fundraising.getFundraisingExpire()));
            preparedStatement.setString(3, String.valueOf(fundraising.getGoal()));
            preparedStatement.setString(4, String.valueOf(fundraising.isGoalAllowed()));
            preparedStatement.setString(5, String.valueOf(fundraising.getCurrentFundSum()));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getFundraising(Fundraising fundraising) {
        ResultSet rs = null;

        String select = "SELECT * FROM " + Const.FUNDRAISING_TABLE + " WHERE " +
                Const.FUNDRAISING_NAME + "=? AND " + Const.FUNDRAISING_EXPIRE + "=?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, fundraising.getFundraisingName());
            preparedStatement.setString(2, String.valueOf(fundraising.getFundraisingExpire()));
            rs = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return  rs;
    }

    public void createTransaction(Transaction transaction) {
        String insert = "INSERT INTO" + Const.TRANSACTION_TABLE + "(" + Const.TRANSACTION_CODE + "," +
                Const.TRANSACTION_SUM + "," + Const.TRANSACTION_TYPE + "," +
                Const.TRANSACTION_TIME + ")" + "VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, transaction.getTransactionCode());
            preparedStatement.setString(2, transaction.getTransactionSum());
            preparedStatement.setString(3, transaction.getTransactionType());
            preparedStatement.setString(4, String.valueOf(transaction.getTransactionTime()));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public ResultSet getTransaction(Transaction transaction) {
        ResultSet rs = null;

        String select = "SELECT * FROM " + Const.TRANSACTION_TABLE + " WHERE " +
                Const.TRANSACTION_CODE + "=?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1, transaction.getTransactionCode());
            rs = preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return  rs;
    }*/
}

