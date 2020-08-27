package com.qa.tests.se;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AlertsTest extends BaseBeforeClass
{
    @Test
    public void alertBoxTest()
    {
        try
        {
            final String url = "https://www.testandquiz.com/selenium/testing.html";
            getWebDriver().get(url);
            Thread.sleep(1000);

            getWebDriver().findElement(By.xpath("/html/body/div/div[11]/div/p/button")).click();

            Thread.sleep(1000);

            Alert alert = getWebDriver().switchTo().alert();
            getLogger().info("\t-> alert text: "+alert.getText());

            Thread.sleep(1000);

            alert.accept();
        }
        catch(Exception e)
        {
            getLogger().severe("\t-> Error occurred: "+e.getMessage());
        }
    }
}
