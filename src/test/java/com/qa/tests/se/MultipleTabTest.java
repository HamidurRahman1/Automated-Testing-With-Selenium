package com.qa.tests.se;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class MultipleTabTest
{
    private static Logger logger;
    private static WebDriver webDriver;

    @BeforeClass
    public void setup()
    {
        logger = Logger.getLogger(URLAndTitleCheckTest.class.getName());
        webDriver = new ChromeDriver();
    }

    @Test(priority = 0, enabled = true)
    public void dropDownTest()
    {
        try
        {
            final String expectedUrl = "https://www.testandquiz.com/selenium/testing.html";

            webDriver.get(expectedUrl);

            Assert.assertEquals(expectedUrl, webDriver.getCurrentUrl());

            // tbi
        }
        catch(Exception e)
        {
            logger.severe("\t-> "+e.getMessage());
        }
    }

    @AfterClass
    public void tearDown()
    {
        webDriver.quit();
        if(webDriver.toString().toLowerCase().contains("null"))
            logger.info("\t-> web driver has successfully quit");
    }
}
