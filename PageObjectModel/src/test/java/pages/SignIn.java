package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.DataFaker;
import utility.Screenshot;

import static utility.Screenshot.*;

public class SignIn extends BasePage {

    public SignIn() {
        super();
    }

    private DataFaker faker = new DataFaker();

    @FindBy(id = "loginId")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(xpath = "//body/div[@id='ng-app']/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/form[1]/div[1]/div[1]/ul[1]/li[2]/a[1]")
    private WebElement submitButton;

    private void fillInSignInForm(String emailAddress, String password){
        emailInput.sendKeys(emailAddress);
        passwordInput.sendKeys(password);
    }

    public void submitSignInFormWithValidEmail(){
        fillInSignInForm(faker.getFakeEmail(),faker.getFakePassword());
        captureScreenshot();
        submitButton.click();
    }


}
