import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.logging.Logger;

public class Main
{
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final WebDriver driver = new ChromeDriver();

    public static void main(String[] args)
    {
        try
        {
            OpenURLAndTitleCheck.run(driver, logger);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            driver.quit();
            if(driver.toString().toLowerCase().contains("null")){
                logger.info("driver has successfully been quit");
            }
        }
    }
}

