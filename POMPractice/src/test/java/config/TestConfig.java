package config;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestConfig {
    private WebDriver driver;

    @Before
    public void setup(){
        String baseUrl = "http://automationpractice.com/index.php";
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }
    @After
    public void cleanup(){
        driver.close();
    }
}
