package pages;

import org.hamcrest.core.IsEqual;
import org.jetbrains.annotations.Nullable;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Screenshot;

import java.io.IOException;

import static utils.Screenshot.captureScreenshot;

public class RublonTotpSignIn  extends  BasePage{

    public RublonTotpSignIn() {
        super();
        wait = new WebDriverWait(driver,WAIT_TIME);
    }

    private WebDriverWait wait;
    @FindBy(id = "vericode" )
    private WebElement totpInput;
    @FindBy(id = "submit-button")
    private WebElement submitButton;
    @FindBy(id = "vericode-alert")
    private WebElement invalidVerificationAlert;
    @FindBy(id = "text-center-style")
    private WebElement qrAuthHeader;
    private final int PASSCODE_LENGTH = 6;
    private final String INCORRECT_PASSCODE = "1";
    private final String EXPECTED_ALERT = "Invalid verification code!";
    private final String EXPECTED_HEADER_TEXT = "Sign in using TOTP";
    private final int WAIT_TIME = 10;

    public WordpressAdmin submitCorrectVerificationCode() throws IOException {
        wait.until((ExpectedCondition<Boolean>) webDriver -> totpInput.getAttribute("value").
                length() == PASSCODE_LENGTH);
        captureScreenshot();
        return new WordpressAdmin();

    }
    public RublonTotpSignIn submitIncorrectVerificationCode() throws IOException {
        totpInput.sendKeys(INCORRECT_PASSCODE);
        captureScreenshot();
        submitButton.click();
        return this;
    }
    public void userShouldSeeInvalidPassCodeAlert(){
        Assert.assertEquals(EXPECTED_ALERT,getAlertMessage());
    }
    private String getAlertMessage(){
        wait.until(ExpectedConditions.visibilityOf(invalidVerificationAlert));
        return invalidVerificationAlert.getText();
    }
    public RublonTotpSignIn userSuccessfullyViewedTotpSignIn(){
        Assert.assertEquals(EXPECTED_HEADER_TEXT,getHeaderText());
        return this;
    }
    public String getHeaderText(){
        return qrAuthHeader.getText();
    }
}
