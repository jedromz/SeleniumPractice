package tests;

import config.TestConfig;
import org.junit.Test;
import pages.Home;

public class RegistrationTest  extends TestConfig {


    @Test
    public void registrationWithValidDataTest(){
        new Home()
                .goToSignInPage()
                .submitEmailCreateAccountFormWithValidData()
                .submitRegisterFormWithValidData()
                .userShouldBeSuccessfullyRegistered();
    }
    @Test
    public void registrationWithInvalidDataShouldFail() {
        new Home()
               .goToSignInPage()
                .submitEmailCreateAccountFormWithValidData()
                .submitRegisterFromWithInvalidData()
                .userShouldSeeRegistrationFormAlert();
    }
}
