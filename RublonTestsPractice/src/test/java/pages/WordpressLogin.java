package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DataFaker;
import utils.Screenshot;

import java.io.IOException;

public class WordpressLogin extends BasePage{

    public WordpressLogin() {
        super();
        faker = new DataFaker();
        wait = new WebDriverWait(driver,WAIT_TIME);
    }
    @FindBy(id = "user_login")
    private WebElement usernameOrEmailInput;
    @FindBy(id = "user_pass")
    private WebElement passwordInput;
    @FindBy(id = "wp-submit")
    private WebElement loginButton;
    @FindBy(id = "login_error")
    private WebElement loginErrorAlert;

    private final String CORRECT_USERNAME = "pjrm";
    private final String CORRECT_PASSWORD = "astecpass123";
    private DataFaker faker;
    private final int WAIT_TIME = 10;
    private final WebDriverWait wait;

    public RublonAuth loginWithCorrectCredentials() throws IOException {
        Screenshot.captureScreenshot();
        usernameOrEmailInput.sendKeys(CORRECT_USERNAME);
        passwordInput.sendKeys(CORRECT_PASSWORD);
        loginButton.click();
        Screenshot.captureScreenshot();
        return new RublonAuth();
    }
    public WordpressLogin loginWithIncorrectCredentials(){
        usernameOrEmailInput.sendKeys(faker.getFakeUsername());
        passwordInput.sendKeys(faker.getFakePassword());

        loginButton.click();
        return this;
    }
    public void loginErrorAlertDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(loginErrorAlert));
        String EXPECTED_ALERT_TEXT = "Unknown username. Check again or try your email address.";
        Assert.assertEquals(EXPECTED_ALERT_TEXT,getAlertText());
    }
    private String getAlertText(){
        return  loginErrorAlert.getText();
    }
}
