package com.maruti.papers.services;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yashdeep Sharma on 10-Sep-16.
 */
public class UserServiceTest {

    @Test
    public void testMatchPassword() throws Exception {

        boolean flag = new UserService().matchPassword("sharma.yashdeep@outlook.com","999799950");
        System.out.println(flag);
    }
}