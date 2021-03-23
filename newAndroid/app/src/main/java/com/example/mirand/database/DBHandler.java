package com.example.mirand.database;
import com.example.mirand.util.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBHandler extends Configs {
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException,SQLException{
        String connection="jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection=DriverManager.getConnection(connection,dbUser,dbPass);
        return dbConnection;
    }
    public void signUpUser(User user){
        String insert = "INSERT INTO"+Const.USER_TABLE+"("+Const.USER_NAME+","+Const.USER_SURNAME+"," +
                Const.USER_BIRTH+","+Const.USER_EMAIL+","+Const.USER_PHONE+")"+
                "VALUES(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement=getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setDate(3,user.getBirthDate());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,user.getTelephoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }
    public ResultSet getUser(User user){
        ResultSet resultSet=null;
        String select="SELECT * FROM "+Const.USER_TABLE+" WHERE "+Const.USER_PHONE+"=?";
        try {
            PreparedStatement preparedStatement=getDbConnection().prepareStatement(select);
            preparedStatement.setString(1,user.getTelephoneNumber());
            resultSet=preparedStatement.executeQuery();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }
}
