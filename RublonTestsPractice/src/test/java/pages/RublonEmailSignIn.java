package pages;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Screenshot;

import java.io.IOException;
import java.util.logging.Logger;

import static utils.Screenshot.captureScreenshot;

public class RublonEmailSignIn extends BasePage {

    public RublonEmailSignIn() {
        super();
    }

    @FindBy(id = "text-center-style")
    private WebElement linkVerificationHeader;
    private final String EXPECTED_HEADER_TEXT = "Sign in using verification link";

    public WordpressAdmin userSuccessfullyViewedEmailVerificationPage() throws IOException {
        String dashboardHeaderText = linkVerificationHeader.getText();

        Assert.assertEquals(EXPECTED_HEADER_TEXT, dashboardHeaderText);
        Screenshot.captureScreenshot();
        return new WordpressAdmin();
    }
}
