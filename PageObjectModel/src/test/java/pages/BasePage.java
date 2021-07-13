package pages;

import config.WebDriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Actions;

import static config.WebDriverSingleton.getInstance;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(getInstance(),this);
        Actions.waitForVisibilityOfElement(pageContent);
    }

    @FindBy(className = "main")
    private WebElement pageContent;
}
