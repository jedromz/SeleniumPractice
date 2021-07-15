package pages;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Screenshot;

import java.io.IOException;

import static utils.Screenshot.captureScreenshot;

public class RublonEmailSignIn extends BasePage{

    public RublonEmailSignIn() {
        super();
    }
    @FindBy(id= "text-center-style")
    private WebElement linkVerificationHeader;

    public WordpressAdmin userSuccessfullyViewedEmailVerificationPage() throws IOException {
        String dashboardHeaderText = linkVerificationHeader.getText();
        String expectedText = "Sign in using verification link";
        Assert.assertThat(dashboardHeaderText, IsEqual.equalTo(expectedText));
        Screenshot.captureScreenshot();
        return new WordpressAdmin();
    }
}
