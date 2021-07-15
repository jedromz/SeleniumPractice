package config;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TestConfig {
    public static final String DRIVER_TYPE = "chrome";
    private WebDriver driver;
    private final int WAIT_TIME = 15;

    @Before
    public void setup(){
        String baseUrl = "http://127.0.0.1/wordpress/wp-login.php";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\p-jrm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = WebDriverFactory.getWebDriver(DRIVER_TYPE).orElseThrow(IllegalArgumentException::new);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WAIT_TIME, TimeUnit.SECONDS);
    }

    @After
    public void cleanup(){
        driver.quit();
    }
}