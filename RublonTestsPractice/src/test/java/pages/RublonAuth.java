package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Screenshot;

import java.io.IOException;

public class RublonAuth extends BasePage{

    public RublonAuth() {
        super();
    }
    @FindBy(id = "push")
    private WebElement pushAuthButton;
    @FindBy(id = "email")
    private WebElement emailAuthButton;

    public WordpressAdmin choosePushAuthentication() throws IOException {
        pushAuthButton.click();
        Screenshot.captureScreenshot();
        return new WordpressAdmin();
    }
    public RublonEmailSignIn chooseEmailAuthentication() throws IOException {
        emailAuthButton.click();
        Screenshot.captureScreenshot();
        return new RublonEmailSignIn();
    }
}
