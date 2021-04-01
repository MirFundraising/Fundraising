package com.restdemo.demo.database;

import com.restdemo.demo.main.Cluster;
import com.restdemo.demo.main.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    // Подключение к базе данных
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        System.out.println("here");
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    // Добавление в базу данных user'a
    public void signUpUser(User user) {
        String insert = "INSERT INTO " + UserConst.USER_TABLE + "(" + UserConst.USER_NAME + "," + UserConst.USER_SURNAME + "," +
                UserConst.USER_EMAIL + "," + UserConst.USER_BIRTH + "," + UserConst.USER_PHONE +")" +
                "VALUES(?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getBirthDate());
//            preparedStatement.setString(5, balance);
            preparedStatement.setString(5, user.getTelephoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createCluster(Cluster cluster) {
        String insert = "INSERT INTO" + ClusterConst.CLUSTER_TABLE + "(" + ClusterConst.CLUSTER_NAME + "," +
                ClusterConst.CLUSTER_PARTICIPANT_COUNTER + "," + ClusterConst.CLUSTER_GOAL + ")" + "VALUES(?,?,?)";

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
