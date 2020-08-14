package com.qa.tests.se;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class NavigationTest
{
    private static Logger logger;
    private static WebDriver webDriver;

    @BeforeClass
    public void setup()
    {
        logger = Logger.getLogger(NavigationTest.class.getName());
        webDriver = new ChromeDriver();
    }

    @Test
    public void navigationTest()
    {
        try
        {
            final String url = "https://github.com/";
            webDriver.navigate().to(url);
            Thread.sleep(2000);

            final String url2 = "https://github.com/HamidurRahman1";
            webDriver.navigate().to(url2);
            Thread.sleep(2000);

            webDriver.navigate().back();
            Thread.sleep(3000);

            webDriver.navigate().forward();
            Thread.sleep(3000);
            Assert.assertEquals(webDriver.getCurrentUrl(), url2);
        }
        catch (Exception e)
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
