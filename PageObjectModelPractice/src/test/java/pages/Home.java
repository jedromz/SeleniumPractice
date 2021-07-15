package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends BasePage {
    public Home() {
        super();
    }
    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInButton;


    public SignIn goToSignInPage(){
        signInButton.click();
        return new SignIn();
    }
}
