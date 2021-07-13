package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.Screenshot;

import static utility.Screenshot.*;

public class Home extends BasePage{
    public Home() {
        super();
    }
    @FindBy(id = "id-user_desktop")
    private WebElement signInButton;
    @FindBy(xpath = "//body[1]/div[1]/div[1]/section[1]/div[3]/div[1]/button[1]")
    private WebElement acceptCookiesButton;

    public SignIn openSigInPage(){
        acceptCookiesButton.click();
        signInButton.click();
        captureScreenshot();
        return new SignIn();
    }
}
