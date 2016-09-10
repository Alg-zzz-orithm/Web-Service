package com.maruti.papers.controllers;

import com.maruti.papers.models.User;
import com.maruti.papers.services.UserService;
import com.maruti.papers.utility.RequestBody;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JSONObject responseJson = new JSONObject();
        UserService userService = new UserService();
        String jsonBody  = RequestBody.getBody(request);
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonBody);
            String emailAddress = (String) jsonObject.get("emailAddress");
            User user = userService.getUserProfile(emailAddress);
            if (user == null){
                responseJson.put("status",400);
                responseJson.put("message","User not exits in the database");
            }
            else{
                responseJson.put("status",200);
                responseJson.put("message","suceess");
                responseJson.put("userId",user.getUserId());
                responseJson.put("firstName",user.getFirstName());
                responseJson.put("lastName",user.getLastName());
                responseJson.put("emailAddress",user.getEmailAddress());
                responseJson.put("mobileNumber",user.getMobileNumber());
            }

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter out = response.getWriter();
        out.print(responseJson);
    }
}
