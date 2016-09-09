package com.maruti.papers.controllers;

import com.maruti.papers.models.User;
import com.maruti.papers.services.UserService;
import com.maruti.papers.utility.RequestBody;s
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        String string  = RequestBody.getBody(request);
        System.out.println(string);
        JSONParser jsonParser = new JSONParser();
        JSONObject responseJson = new JSONObject();

        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(string);
            String firstName = (String) jsonObject.get("firstName");
            String lastName = (String) jsonObject.get("lastName");
            String emailAddress = (String) jsonObject.get("emailAddress");
            String password = (String) jsonObject.get("password");
            String mobileNumber = (String) jsonObject.get("mobileNumber");

            if (userService.isUserExist(emailAddress)) {
                System.out.println("User Exists");
                responseJson.put("status",200);
                responseJson.put("message","User already exists in the database");
            }
            else{
                System.out.println("User Dont Exists");
                responseJson.put("status",400);
                responseJson.put("message","User registeration Successful");
                userService.insertUser(new User(firstName,lastName,emailAddress,password, mobileNumber));

            }
        } catch (ParseException exception) {
            exception.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.print(responseJson);


    }
}
