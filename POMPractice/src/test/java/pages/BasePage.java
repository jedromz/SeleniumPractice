package pages;

import config.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Actions;

public class BasePage {
    WebDriver driver;

    public BasePage() {

        PageFactory.initElements(WebDriverSingleton.getInstance(),this);
        Actions.waitForVisibilityOfElement(pageContent);
    }

    @FindBy(id = "columns")
    private WebElement pageContent;
}
