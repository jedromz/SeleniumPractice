package pages;

import config.TestConfig;
import config.WebDriverFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Actions;

import static utils.Actions.*;

public class BasePage {

   WebDriver driver;

    public BasePage() {
        driver = WebDriverFactory.getWebDriver(TestConfig.DRIVER_TYPE)
                .orElseThrow(IllegalArgumentException::new);
        PageFactory.initElements(driver,this);
        waitForVisibility(pageContent);
    }
    @FindBy(id = "columns")
    private WebElement pageContent;
}
