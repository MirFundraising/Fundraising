package com.example.demo.database;


import com.example.demo.serverClasses.Cluster;
import com.example.demo.serverClasses.User;

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

    // Добавление в базу данных user'a
    public void signUpUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_NAME + "," + Const.USER_SURNAME + "," +
                Const.USER_EMAIL + "," + Const.USER_BIRTHDATE + /*"," + Const.USER_BALANCE + "," + Const.USER_PHONE +*/ ")" +
                "VALUES(?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getBirthDate());
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
}

