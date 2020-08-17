package com.qa.tests.se;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
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
            webDriver.get("https://github.com/login");

            GitHubLoginPOM pageObject = PageFactory.initElements(webDriver, GitHubLoginPOM.class);
            pageObject.getUsername().sendKeys("myGithubUsername");

            long withoutCacheStartTime = System.currentTimeMillis();
            for(int i = 1; i <= 1000; i ++)
                pageObject.getUsername().getText();

            System.out.println("Time taken in seconds Without cache: " + ((System.currentTimeMillis() - withoutCacheStartTime)/ 1000));

            pageObject.getPassword().sendKeys("Github#@pass");
            long withCacheStartTime = System.currentTimeMillis();
            for(int i = 1; i <= 1000; i ++)
                pageObject.getPassword().getText();

            System.out.println("Time taken in seconds With cache: " + ((System.currentTimeMillis() - withCacheStartTime)/ 1000));
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
