package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AlertsPage;

import java.util.concurrent.TimeUnit;

public class AlertTests {
    WebDriver driver;
    AlertsPage alertsPage;
    WebDriverWait wait;


    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\p-jrm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Alerts.html");
        alertsPage = new AlertsPage(driver);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
    }
    @Test
    public void acceptInfoAlertTest() throws InterruptedException {
        alertsPage.clickInfoAlertLink();
        wait.until(ExpectedConditions.elementToBeClickable(alertsPage.getInfoAlertButton()));
        alertsPage.clickInfoAlertButton();
        driver.switchTo().alert().accept();
    }
    @Test
    public void cancelInfoAlertTest() throws InterruptedException {
        alertsPage.clickInfoAlertLink();
        wait.until(ExpectedConditions.elementToBeClickable(alertsPage.getInfoAlertButton()));
        alertsPage.clickInfoAlertButton();
        driver.switchTo().alert().dismiss();
    }
    @Test
    public void sendCorrectInputToPromptAlertAndAcceptTest() throws InterruptedException {
        alertsPage.clickPromptAlertLink();
        wait.until(ExpectedConditions.elementToBeClickable(alertsPage.getPromptAlertButton()));
        alertsPage.clickPromptAlertButton();
        alertsPage.sendDataToPromptAlertAndAccept(driver.switchTo().alert(), "Bob");
        Thread.sleep(3000);
    }
    @After
    public void cleanup(){
        driver.close();
    }
}
