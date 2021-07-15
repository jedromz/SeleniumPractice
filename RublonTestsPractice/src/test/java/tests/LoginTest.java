package tests;

import config.TestConfig;
import org.junit.Test;
import pages.WordpressLogin;

import java.io.IOException;

public class LoginTest extends TestConfig {

    @Test
    public void loginWithPushAuthAndValidCredentialsTest() throws InterruptedException, IOException {
        new WordpressLogin()
                .login("pjrm", "astecpass123")
                .choosePushAuthentication()
                .userSuccessfullyAuthenticated();

    }
    @Test
    public void loginWithEmailVerificationAndValidCredentialsTest() throws IOException {
        new WordpressLogin()
                .login("pjrm","astecpass123")
                .chooseEmailAuthentication()
                .userSuccessfullyViewedEmailVerificationPage()
                .userSuccessfullyAuthenticated();
    }
}
