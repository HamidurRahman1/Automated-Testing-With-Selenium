package com.qa.tests.se;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
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
            final String url = "https://www.testandquiz.com/selenium/testing.html";

            webDriver.get(url);

            Thread.sleep(1000);
            Assert.assertEquals(url, webDriver.getCurrentUrl());

            String mainWindow = webDriver.getWindowHandle();
            logger.info("\t-> the main window: " + mainWindow);

            for (int i = 1; i <= 2; i++)
            {
//                webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.COMMAND +"t");
                JavascriptExecutor js = (JavascriptExecutor) webDriver;
                js.executeScript("window.open();");
                Thread.sleep(2000);
            }

            Set<String> allTabs = webDriver.getWindowHandles();
            logger.info("\t-> total windows: " + allTabs.size());
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
