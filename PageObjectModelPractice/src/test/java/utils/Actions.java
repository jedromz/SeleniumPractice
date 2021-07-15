package utils;

import config.TestConfig;
import config.WebDriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

public class Actions {

    private static final int WAIT_TIMEOUT = 10;
    private static  WebDriverWait wait = new WebDriverWait(WebDriverFactory.getWebDriver(TestConfig.DRIVER_TYPE)
            .orElseThrow(IllegalArgumentException::new),WAIT_TIMEOUT);

    public static void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
