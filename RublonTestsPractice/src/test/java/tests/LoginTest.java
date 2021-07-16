package tests;

import config.TestConfig;
import org.junit.Test;
import pages.WordpressLogin;

import java.io.IOException;

public class LoginTest extends TestConfig {

    @Test
    public void loginWithPushAuthTest() throws InterruptedException, IOException {
        new WordpressLogin()
                .loginWithCorrectCredentials()
                .choosePushAuthentication()
                .userSuccessfullyViewedPushSignInPage()
                .accessGranted()
                .userSuccessfullyAuthenticated();


    }

    @Test
    public void loginWithEmailAuthTest() throws IOException {
        new WordpressLogin()
                .loginWithCorrectCredentials()
                .chooseEmailAuthentication()
                .userSuccessfullyViewedEmailVerificationPage()
                .userSuccessfullyAuthenticated();
    }

    @Test
    public void loginWithTotpAuthTest() throws IOException {
        new WordpressLogin()
                .loginWithCorrectCredentials()
                .chooseTotpAuthentication()
                .userSuccessfullyViewedTotpSignIn()
                .submitCorrectVerificationCode()
                .userSuccessfullyAuthenticated();
    }
    @Test
    public void loginWithQrCodeAuthTest() throws IOException {
        new WordpressLogin()
                .loginWithCorrectCredentials()
                .chooseQrCodeAuthentication()
                .userSuccessfullyViewedQrCodeVerificationPage()
                .userSuccessfullyAuthenticated();
    }
    @Test
    public void authenticationWithIncorrectTotpTest() throws IOException {
        new WordpressLogin()
                .loginWithCorrectCredentials()
                .chooseTotpAuthentication()
                .userSuccessfullyViewedTotpSignIn()
                .submitIncorrectVerificationCode()
                .userShouldSeeInvalidPassCodeAlert();
    }
    @Test
    public void pushAuthAccessDeniedTest() throws IOException {
        new WordpressLogin()
                .loginWithCorrectCredentials()
                .choosePushAuthentication()
                .userSuccessfullyViewedPushSignInPage()
                .accessDenied()
                .userViewedAccessDeniedPage();

    }
    @Test
    public void loginWithIncorrectCredentials(){
        new WordpressLogin()
                .loginWithIncorrectCredentials()
                .loginErrorAlertDisplayed();
    }
}