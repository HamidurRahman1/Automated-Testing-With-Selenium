package com.qa.tests.se;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class URLAndTitleCheckTest
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
    public void urlAndTitleTest()
    {
        try
        {
            final String expectedUrl = "https://www.testandquiz.com/selenium/testing.html";
            final String expectedTitle = "Sample Test Page";

            webDriver.get(expectedUrl);

            Assert.assertTrue(webDriver.getCurrentUrl().equals(expectedUrl));
            logger.info("\t-> url check is done and passed");
            Assert.assertTrue(webDriver.getTitle().equals(expectedTitle));
            logger.info("\t-> title check is done and passed");
        }
        catch(Exception e)
        {
            logger.severe("\t-> Error occurred: "+e.getMessage());
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
