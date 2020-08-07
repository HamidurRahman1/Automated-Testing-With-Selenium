package com.qa.tests.se;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class DragAndDropTest
{
    private static Logger logger;
    private static WebDriver webDriver;

    @BeforeClass
    public void setup()
    {
        logger = Logger.getLogger(URLAndTitleCheckTest.class.getName());
        webDriver = new ChromeDriver();
    }

    @Test
    public void dragAndDropTest()
    {
        try
        {
            final String url = "https://www.testandquiz.com/selenium/testing.html";

            webDriver.get(url);

            WebElement from = webDriver.findElement(By.id("sourceImage"));
            WebElement to = webDriver.findElement(By.id("targetDiv"));

            new Actions(webDriver).dragAndDrop(from, to).build().perform();

            Thread.sleep(5000);
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
