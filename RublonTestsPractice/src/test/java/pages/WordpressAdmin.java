package pages;

import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Screenshot;

import java.io.IOException;

import static utils.Screenshot.*;

public class WordpressAdmin extends BasePage {

    public WordpressAdmin() {
        super();
    }

    @FindBy(xpath = "//h1[text() = 'Dashboard']")
    private WebElement dashboardHeader;

    public void userSuccessfullyAuthenticated() throws IOException {
        String dashboardHeaderText = dashboardHeader.getText();
        String expectedText = "Dashboard";
        Assert.assertThat(dashboardHeaderText, IsEqual.equalTo(expectedText));
        captureScreenshot();
    }
}
