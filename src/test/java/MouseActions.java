import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MouseActions {
    WebDriver driver;
        String TestPage = "https://the-internet.herokuapp.com/";

    @BeforeEach
    public void SetUp() {
        driver = WebDriverManager.chromedriver().avoidShutdownHook().create();
    }

    @Test
    public void MouseActionsTest(){
        driver.get(TestPage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(driver.getTitle().equals("The Internet"));
    }


}
