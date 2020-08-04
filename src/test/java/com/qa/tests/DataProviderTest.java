package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest
{
    @DataProvider(name = "user_pass")
    public Object[][] userNamePassword()
    {
        // # of rows matches the invocation of the methods are going to use the data provider function
        // # of columns matches the # of params

        Object[][] data = new Object[2][2];
        data[0][0] = "testUser1";   data[0][1] = "testUserPass1";
        data[1][0] = "testUser2";   data[1][1] = "testUserPass2";
        return data;
    }

    @Test(dataProvider = "user_pass", invocationCount = 1, description = "this is method is a repetitive test based on data provider")
    public void repetitiveTest(String username, String pass)
    {
        System.out.println(username + " - " + pass);
    }

    @Test
    public void hardAssertTest()
    {
        // hard asserts are just regular assert in TestNg. If any assert fails then the whole test fails. If any exceptions
        // are thrown and not handled then the whole program execution stops
        Assert.assertTrue(true);
        Assert.assertEquals(1, 1);
        Assert.assertTrue(true);
    }
}