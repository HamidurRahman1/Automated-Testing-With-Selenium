package com.qa.tests.se;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class DropDownTest
{
    private static Logger logger;
    private static WebDriver webDriver;

    @BeforeClass
    public void setup()
    {
        logger = Logger.getLogger(DropDownTest.class.getName());
        webDriver = new ChromeDriver();
    }

    @Test(priority = 0, enabled = true)
    public void dropDownTest()
    {
        try
        {
            final String expectedUrl = "https://www.testandquiz.com/selenium/testing.html";

            webDriver.get(expectedUrl);
            webDriver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

            WebElement selectElement = webDriver.findElement(By.id("testingDropdown"));

            Select selectElementHolder = new Select(selectElement);
            System.out.println("Selected Options -> ");
            selectElementHolder.getAllSelectedOptions().forEach(e -> System.out.println(e.getText()));
            System.out.println("All Options -> ");
            selectElementHolder.getOptions().forEach(e -> System.out.println(e.getText()));

            String automationVisibleText = "Automation Testing";
            String dbValue = "Database";
            selectElementHolder.selectByValue(dbValue);

            Thread.sleep(2000);

            selectElementHolder.selectByIndex(1);

            Thread.sleep(2000);

            selectElementHolder.selectByVisibleText(automationVisibleText);

            Thread.sleep(2000);

            Assert.assertEquals(automationVisibleText, selectElementHolder.getFirstSelectedOption().getText());
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
