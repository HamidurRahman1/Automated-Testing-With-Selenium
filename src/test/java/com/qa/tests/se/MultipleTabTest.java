package com.qa.tests.se;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MultipleTabTest
{
    private static Logger logger;
    private static WebDriver webDriver;

    @BeforeClass
    public void setup()
    {
        logger = Logger.getLogger(MultipleTabTest.class.getName());
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
                JavascriptExecutor js = (JavascriptExecutor) webDriver;
                js.executeScript("window.open();");

                List<String> tabs = webDriver.getWindowHandles().stream().collect(Collectors.toList());
                final String lastOpenTab = tabs.get(tabs.size()-1);

                webDriver.switchTo().window(lastOpenTab);
                webDriver.get(url);

                Assert.assertEquals(url, webDriver.getCurrentUrl());
                Thread.sleep(2000);
            }

            Set<String> allTabs = webDriver.getWindowHandles();
            logger.info("\t-> total windows: " + allTabs.size());

            Thread.sleep(3000);

            allTabs.forEach(e -> {
                if(!e.equalsIgnoreCase(mainWindow))
                {
                    try
                    {
                        webDriver.switchTo().window(e);
                        Thread.sleep(2000);
                        webDriver.close();
                    }
                    catch (InterruptedException ex)
                    {
                        logger.severe("\t-> Error occurred: "+ex.getMessage());
                    }
                }
            });

            webDriver.switchTo().window(mainWindow);

            Thread.sleep(2000);
            logger.info("\t-> the main window: "+webDriver.getWindowHandle());

            Assert.assertEquals(mainWindow, webDriver.getWindowHandle());
            Thread.sleep(2000);
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
