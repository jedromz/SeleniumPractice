import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Waits {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\p-jrm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        String[] items = {"Cucumber","Broccoli","Beetroot"};
        addItems(driver,items);
    }
    public static void addItems(WebDriver driver,String[] items){
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {

        }
    }
}
