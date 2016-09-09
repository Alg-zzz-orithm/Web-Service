package com.maruti.papers.services;

import com.maruti.papers.database.Database;
import com.maruti.papers.models.User;

import java.sql.ResultSet;

public class UserService {

    public void insertUser(User user) throws Exception{
        Database database = new Database();
        database.executeSqlQuery("insert into user(FIRST_NAME,LAST_NAME,EMAIL_ADDRESS,PASSWORD,MOBILE_NUMBER) VALUES (" + user.getFirstName() + "," + user.getLastName() + "," + user.getEmailAddress() + "," + user.getPassword() + "," +  user.getMobileNumber() + ")");
    }     


    //  use  prepared  statament  here




    public boolean isUserExist(String emailAddress) throws Exception{
        Database database = new Database();
        ResultSet resultSet = database.executeSqlQuery("select * from user where EMAIL_ADDRESS='" + emailAddress + "'" );
        if(resultSet == null){
            return false;
        }
        else{
            return true;


        }
    }
}
