package pages;

import org.hamcrest.core.IsCollectionContaining;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.Actions;
import utils.DataFaker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SignUp extends BasePage {
    public SignUp() {
        super();
        faker = new DataFaker();
    }

    private DataFaker faker;
    @FindBy(id = "id_gender1")
    private WebElement maleInputButton;
    @FindBy(id = "id_gender2")
    private WebElement femaleInputButton;
    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;
    @FindBy(id = "customer_lastname")
    private WebElement lastnameInput;
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    @FindBy(id = "days")
    private WebElement birthdateDaySelect;
    @FindBy(id = "months")
    private WebElement birthdateMonthSelect;
    @FindBy(id = "years")
    private WebElement birthdateYearSelect;
    @FindBy(id = "address1")
    private WebElement addressLine1;
    @FindBy(id = "city")
    private WebElement cityInput;
    @FindBy(id = "id_state")
    private WebElement stateSelect;
    @FindBy(id = "postcode")
    private WebElement postCodeInput;
    @FindBy(id = "id_country")
    private WebElement countryInput;
    @FindBy(id = "phone_mobile")
    private WebElement phoneInput;
    @FindBy(id = "submitAccount")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    private List<WebElement> alertMessageContent;

    private void fillInData(boolean valid) {
        Actions.waitForVisibility(firstNameInput);
        if (valid) {
            firstNameInput.sendKeys(faker.getFakeFirstname());
        }
        lastnameInput.sendKeys(faker.getFakeLastname());
        passwordInput.sendKeys(faker.getFakePassword());
        new Select(birthdateDaySelect).selectByValue("12");
        new Select(birthdateMonthSelect).selectByValue("11");
        new Select(birthdateYearSelect).selectByValue("2000");
        addressLine1.sendKeys(faker.getFakeStreet());
        cityInput.sendKeys(faker.getFakeCity());
        new Select(stateSelect).selectByValue("4");
        postCodeInput.sendKeys("11234");
        phoneInput.sendKeys(faker.getFakeMobilePhone());

    }

    public Profile submitRegisterFormWithValidData() {
        fillInData(true);
        submitButton.click();
        return new Profile();
    }
    public SignUp submitRegisterFromWithInvalidData(){
        fillInData(false);
        submitButton.click();
        return this;
    }
    public void userShouldSeeRegistrationFormAlert(){
        String EXPECTED_MESSAGE = "firstname is required.";
        Assert.assertThat(getAlertMessages(), IsCollectionContaining.hasItem(EXPECTED_MESSAGE));
    }
    private List<String> getAlertMessages(){
        List<String> alertMessages = new ArrayList<>();
        alertMessageContent.stream()
                .map(WebElement::getText)
                .collect(Collectors.toCollection(()->alertMessages));
        return alertMessages;
    }
}