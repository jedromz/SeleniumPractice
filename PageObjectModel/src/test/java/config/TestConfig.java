package config;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static config.WebDriverSingleton.*;

public class TestConfig {

    private WebDriver driver;

    @Before
    public void setup(){
        String baseUrl = "https://www.bmw.pl/pl/index.html";

        driver = getInstance();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @After
    public void cleanup(){
        quit();
    }
}
