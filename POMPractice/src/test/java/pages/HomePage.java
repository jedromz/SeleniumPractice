package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage() {
        super();
    }
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement signInButton;

    @Step
    public SignIn goToSignInPage(){

    }
}
