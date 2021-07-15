package pages;

import config.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Screenshot;

import java.io.IOException;

public class BasePage {

    private WebDriver driver;

    public BasePage(){
        driver = WebDriverFactory.getWebDriver(WebDriverFactory.CHROME_DRIVER)
                .orElseThrow(IllegalArgumentException::new);
        PageFactory.initElements(driver,this);

    }
}
