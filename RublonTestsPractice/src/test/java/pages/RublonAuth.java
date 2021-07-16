package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Screenshot;

import java.io.IOException;

public class RublonAuth extends BasePage {

    public RublonAuth() {
        super();
    }

    @FindBy(id = "push")
    private WebElement pushAuthButton;
    @FindBy(id = "email")
    private WebElement emailAuthButton;
    @FindBy(id = "totp")
    private WebElement totpAuthButton;
    @FindBy(id = "qrcode")
    private WebElement qrCodeAuthButton;

    public RublonPushSignIn choosePushAuthentication() throws IOException {
        pushAuthButton.click();
        Screenshot.captureScreenshot();
        return new RublonPushSignIn();
    }

    public RublonEmailSignIn chooseEmailAuthentication() throws IOException {
        emailAuthButton.click();
        Screenshot.captureScreenshot();
        return new RublonEmailSignIn();
    }

    public RublonTotpSignIn chooseTotpAuthentication() throws IOException {
        totpAuthButton.click();
        Screenshot.captureScreenshot();
        return new RublonTotpSignIn();

    }
    public RublonQrCodeSignIn chooseQrCodeAuthentication() throws IOException {
        qrCodeAuthButton.click();
        Screenshot.captureScreenshot();
        return new RublonQrCodeSignIn();
    }
}
