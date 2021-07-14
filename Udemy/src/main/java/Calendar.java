import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Calendar {
    public static void main(String[] args) {
        String expectedText = "BpkCalendarDate_bpk-calendar-date__1M0FZ";
        System.setProperty("webdriver.chrome.driver","C:\\Users\\p-jrm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.get("https://www.skyscanner.pl/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement cookiesOK = driver.findElement(By.cssSelector(".CookieBanner_CookieBanner__buttons-wrapper__qmx03 .CookieBanner_CookieBanner__accept-button__23K1b"));
        cookiesOK.click();
        driver.findElement(By.id("depart-fsc-datepicker-button")).click();

        var days = driver.findElements(By.xpath("//div[contains(text(),'BpkCalendarDate_bpk-calendar-date__1M0FZ')]"));

        System.out.println(days.size());
        for (WebElement day : days) {
            if(day.getText().equalsIgnoreCase("28")){
                day.click();
                break;
            }
        }
    }
}
