package pages;


import org.hamcrest.core.IsEqual;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile extends BasePage {

    public Profile() {
        super();
    }

    @FindBy(css = "#center_column > h1")
    private WebElement profilePageHeader;


    public void userShouldBeSuccessfullyRegistered() {
        String profilePageHeaderText = profilePageHeader.getText();
        String expectedHeaderText = "MY ACCOUNT";

        Assert.assertThat(profilePageHeaderText, IsEqual.equalTo(expectedHeaderText));
    }
}