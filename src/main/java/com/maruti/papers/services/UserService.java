package com.maruti.papers.services;

import com.maruti.papers.database.Database;
import com.maruti.papers.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {

    public void insertUser(User user) throws Exception{
        Database database = new Database();
        Connection connection = database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (FIRST_NAME,LAST_NAME,EMAIL_ADDRESS,PASSWORD,MOBILE_NUMBER) VALUES (?,?,?,?,?)");
        preparedStatement.setString(1,user.getFirstName());
        preparedStatement.setString(2,user.getLastName());
        preparedStatement.setString(3,user.getEmailAddress());
        preparedStatement.setString(4,user.getPassword());
        preparedStatement.setString(5,user.getMobileNumber());
        preparedStatement.executeUpdate();
    }

    public boolean isUserExist(String emailAddress) throws Exception{
        Database database =  new Database();
        Connection connection = database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM user WHERE EMAIL_ADDRESS = ?");
        preparedStatement.setString(1,emailAddress);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            if (resultSet.getInt(1) == 0){
                return false;
            }
            else{
                return true;
            }
        }
        else {
            return false;
        }
    }

    public boolean matchPassword(String emailAddress,String password) throws Exception{
        Database database = new Database();
        Connection connection = database.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT PASSWORD FROM user WHERE EMAIL_ADDRESS = ?");
        preparedStatement.setString(1,emailAddress);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            String passwordToBeMatched = resultSet.getString("PASSWORD");
            if (passwordToBeMatched.equals(password)){
                return true;
            }
            else{
                return false;
            }
        }
        else {
            return false;
        }
    }
}
