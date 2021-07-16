package pages;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Screenshot;

import java.io.IOException;

public class RublonQrCodeSignIn extends BasePage {
    public RublonQrCodeSignIn() {
        super();
    }
    @FindBy(id = "text-center-style")
    private WebElement qrCodeVerificationHeader;

    public WordpressAdmin userSuccessfullyViewedQrCodeVerificationPage() throws IOException {
        String dashboardHeaderText = qrCodeVerificationHeader.getText();
        String expectedText = "Sign in by scanning QR code (Rublon app required)";
        Assert.assertThat(dashboardHeaderText, IsEqual.equalTo(expectedText));
        Screenshot.captureScreenshot();
        return new WordpressAdmin();
    }

}
