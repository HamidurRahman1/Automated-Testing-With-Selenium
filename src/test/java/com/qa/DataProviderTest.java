package com.qa;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
        Assert.assertEquals(1, 1/0);
        Assert.assertTrue(true);
    }

    @Test
    public void softAssertTest()
    {
        // soft assert does the assertion at the end or whenever assertAll() is called
        // even if there are exceptions in assertions (before assertAll()) then program will still continue
        // and the result will produce on assertAll() call

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Hello", "Hello", "First soft assert failed");
        softAssert.assertTrue("Hello".equals("hello"), "Second soft assert failed");
        softAssert.assertTrue("Welcome".equals("welcomeeee"), "Third soft assert failed");
        softAssert.assertAll();
    }
}
