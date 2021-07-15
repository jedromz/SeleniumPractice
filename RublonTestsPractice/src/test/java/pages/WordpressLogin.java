package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Screenshot;

import java.io.IOException;

public class WordpressLogin extends BasePage{

    public WordpressLogin() {
        super();
    }
    @FindBy(id = "user_login")
    private WebElement usernameOrEmailInput;
    @FindBy(id = "user_pass")
    private WebElement passwordInput;
    @FindBy(id = "wp-submit")
    private WebElement loginButton;

    public RublonAuth login(String username,String password) throws IOException {
        Screenshot.captureScreenshot();
        usernameOrEmailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        Screenshot.captureScreenshot();
        return new RublonAuth();
    }
}
