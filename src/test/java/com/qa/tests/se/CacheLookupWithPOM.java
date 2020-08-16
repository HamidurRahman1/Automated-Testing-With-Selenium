package com.qa.tests.se;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.logging.Logger;

/*
    @CacheLookup will cache the the element(s) whenever first found and every subsequent call to will return the
    cache version of it. Using this @ will save time finding element(s) by going through DOM. It is useful when with
    static element(s) in nature.
 */
public class CacheLookupWithPOM
{
    private static Logger logger;
    private static WebDriver webDriver;

    @BeforeClass
    public void setup()
    {
        logger = Logger.getLogger(CacheLookupWithPOM.class.getName());
        webDriver = new ChromeDriver();
    }

    @Test
    public void cacheLookupWithPOMtest()
    {
        try
        {
            // tbi
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
