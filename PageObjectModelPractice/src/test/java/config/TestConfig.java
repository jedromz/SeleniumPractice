package config;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestConfig {
    public static final String DRIVER_TYPE = "chrome";
    private WebDriver driver;


    @Before
    public void setup(){
        String baseUrl = "http://automationpractice.com/index.php";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\p-jrm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = WebDriverFactory.getWebDriver(DRIVER_TYPE).orElseThrow(IllegalArgumentException::new);
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    public void cleanup(){
    driver.quit();
    }
}
