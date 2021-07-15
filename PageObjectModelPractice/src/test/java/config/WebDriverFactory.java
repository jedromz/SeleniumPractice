package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Optional;

public class WebDriverFactory {

    private static WebDriver driver = new ChromeDriver();
    public static Optional<WebDriver> getWebDriver(String driverType){
        switch (driverType) {
            case "chrome":
                return Optional.of(driver);
            case "firefox":
                return Optional.of( new FirefoxDriver());
            default:
                return Optional.empty();
        }
    }
}
