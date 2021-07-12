package tests;

import listeners.EventCapture;
import listeners.ListenerTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import pages.AlertsPage;

@Listeners(ListenerTest.class)
public class ListenerTests {
    WebDriver driver;
    WebDriverWait wait;
    EventCapture eventCapture;
    JavascriptExecutor jsExecutor;
    EventFiringWebDriver eventHandler;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\p-jrm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,2);
        eventCapture = new EventCapture();
        eventHandler = new EventFiringWebDriver(driver).register(eventCapture);
        jsExecutor = (JavascriptExecutor) driver;
    }
    @Test
    public void listenersTest() throws InterruptedException {
        eventHandler.navigate().to("https://www.edureka.co/blog/");
        jsExecutor.executeScript("window.scrollBy(0,800)");
        Thread.sleep(3000);
        eventHandler.findElement(new By.ByPartialLinkText("What is PMP")).click();
        eventHandler.unregister(eventCapture);


    }
    @After
    public void cleanup(){
        eventHandler.quit();
    }
}
