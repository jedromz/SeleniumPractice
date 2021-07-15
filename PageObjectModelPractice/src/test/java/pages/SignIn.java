package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DataFaker;

public class SignIn extends BasePage {
    public SignIn() {
        super();
        faker = new DataFaker();
    }
    private DataFaker faker;
    @FindBy(id = "email_create")
    private WebElement emailInput;
    @FindBy(id = "SubmitCreate")
    private WebElement submitButton;

    public SignUp submitEmailCreateAccountFormWithValidData(){
        fillInEmailForm(faker.getFakeEmail());
        submitButton.click();
        return new SignUp();
    }
    private void fillInEmailForm(String email){
        emailInput.sendKeys(email);
    }
}
