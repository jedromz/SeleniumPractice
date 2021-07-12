import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestive {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\p-jrm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        driver.findElement(By.id("autosuggest")).sendKeys("pol");
        Thread.sleep(2000);
        List<WebElement> options =   driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement option : options) {
            if(option.getText().equalsIgnoreCase("poland")){
                option.click();
                break;
            }
        }
    }
}
