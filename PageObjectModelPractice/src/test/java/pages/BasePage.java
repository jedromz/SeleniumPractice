package pages;

import config.TestConfig;
import config.WebDriverFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Operations;

import static utils.Operations.*;

public class BasePage {

   WebDriver driver;
   Actions actions;
   JavascriptExecutor js;
    public BasePage() {
        driver = WebDriverFactory.getWebDriver(TestConfig.DRIVER_TYPE)
                .orElseThrow(IllegalArgumentException::new);
        actions = new Actions(driver);
        js = (JavascriptExecutor)driver;
        PageFactory.initElements(driver,this);
        waitForVisibility(pageContent);
    }
    @FindBy(id = "columns")
    private WebElement pageContent;
}
