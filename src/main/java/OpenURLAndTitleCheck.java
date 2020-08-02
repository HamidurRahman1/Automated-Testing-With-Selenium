import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class OpenURLAndTitleCheck
{
    public static void run(WebDriver webDriver, Logger logger)
    {
        try
        {
            final String url = "https://www.testandquiz.com/selenium/testing.html";
            final String actualTitle = "Sample Test Page";

            webDriver.get(url);

            logger.info("Testing if opened url is the current url => "+webDriver.getCurrentUrl().equals(url));
            logger.info("Testing if actual title and expected title is same => "+webDriver.getTitle().equals(actualTitle));
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
