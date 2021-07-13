package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.util.concurrent.TimeUnit;

public class NavigationTest {

    WebDriver driver;
    HomePage homePage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\p-jrm\\Downloads\\chromedriver_win32\\chromedriver.exe");
         driver = new ChromeDriver();
        driver.get("https://www.bmw.pl/pl/index.html?tl=sea-goog-alwo-tac-miy-rang-sear-local123-20200303-socclimb-&clc=BMW.Digital&ctid=Google_Google_SG_Range_1630&ccid=2260&gclid=EAIaIQobChMIsZP_rsvQ8QIVGgB7Ch1YcgCEEAAYASAAEgIrafD_BwE");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }
    @Test
    public void openModelsPageFromHomepageTest() throws InterruptedException {
        homePage.openModelsPage();
        Thread.sleep(3000);
    }
    @After
    public void cleanup(){
        driver.quit();
    }
}
