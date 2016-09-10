package com.maruti.papers.services;

import com.maruti.papers.models.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yashdeep Sharma on 10-Sep-16.
 */
public class UserServiceTest {

    @Test
    public void testGetUserProfile() throws Exception {
        UserService userService = new UserService();
        User user = userService.getUserProfile("sharma.upasa@outlook.com");
        System.out.println(user);
    }
}