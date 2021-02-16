package com.company.database;

import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException,SQLException{
        String connectionString="jdbc:mysql://"+dbHost+":"+dbPort+"/"+dbName;
        Class.forName("com.mysql.jdbc.Driver");
        dbConnection=DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }
    public void signUpUser(String name,String surname,String birthdate,String password,String email,String phone){
        String insert="INSERT INTO "+Const.USER_TABLE+"("+ Const.USER_NAME + "," +Const.USER_SURNAME+","+
                Const.USER_BIRTHDATE+","+Const.USER_PASSWORD+","+Const.USER_EMAIL+","+Const.USER_PHONE+")"+
                "VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement=getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,surname);
            preparedStatement.setString(3,birthdate);
            preparedStatement.setString(4,password);
            preparedStatement.setString(5,email);
            preparedStatement.setString(6,phone);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
