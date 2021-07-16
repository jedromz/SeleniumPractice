package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccessDenied extends BasePage {

    public AccessDenied() {
        super();
    }

    @FindBy(xpath = "//h1[contains(text(),'Access denied!')]")
    private WebElement accessDeniedHeader;
    private final String EXPECTED_ALERT_TEXT = "Access denied!";

    public void userViewedAccessDeniedPage() {
        String headerText = accessDeniedHeader.getText();
        Assert.assertEquals(EXPECTED_ALERT_TEXT,headerText);
    }

}
