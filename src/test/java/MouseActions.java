import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MouseActions {
    WebDriver driver= WebDriverManager.chromedriver().avoidShutdownHook().create();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    String TestPage = "https://the-internet.herokuapp.com/";

    @BeforeEach
    public void SetUp() {
        driver.get(TestPage);
    }

    @Test
    @Order(1)
    public void HoverTest() throws InterruptedException {
        Assert.assertTrue(driver.getTitle().equals("The Internet"));
        driver.findElement(By.cssSelector("a[href='/hovers']")).click();
        //to be updated
        driver.close();
    }

    @Test
    @Order(2)
    public void AlertsTest(){
        driver.findElement(By.cssSelector("a[href='/javascript_alerts']")).click();
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().equals("I am a JS Alert"));
        driver.quit();
    }

}
