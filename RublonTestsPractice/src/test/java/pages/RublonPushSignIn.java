package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RublonPushSignIn extends BasePage {
    public RublonPushSignIn() {
        super();
    }
    @FindBy(id = "text-center-style")
    private WebElement pushAuthHeader;
    private final String EXPECTED_HEADER_TEXT = "Sign in using Push notification";

    public RublonPushSignIn userSuccessfullyViewedPushSignInPage(){
        Assert.assertEquals(EXPECTED_HEADER_TEXT,getHeaderText());
        return this;
    }
    public AccessDenied accessDenied(){
        return new AccessDenied();
    }
    public WordpressAdmin accessGranted(){
        return new WordpressAdmin();
    }
    private String getHeaderText(){
        return pushAuthHeader.getText();
    }
}
