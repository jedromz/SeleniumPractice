package tests;

import config.TestConfig;
import org.intellij.lang.annotations.JdkConstants;
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

    @Test
    public void addFeaturedItemsToBasket() throws InterruptedException {
        new Home()
                .addFeaturedItemsToBasket();
        Thread.sleep(5000);
    }
}
