package tests;

import config.TestConfig;
import org.junit.Test;
import pages.Home;

public class SignInTest extends TestConfig {

    @Test
    public void userShouldSuccessfullyRegister() {
        new Home()
                .openSigInPage()
                .submitSignInFormWithValidEmail();
    }
}
