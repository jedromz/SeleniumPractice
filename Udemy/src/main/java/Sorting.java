import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.stream.Collectors;

public class Sorting {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\p-jrm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//thead/tr[1]/th[1]")).click();
        var productsElements = driver.findElements(By.xpath("//tr/td[1]"));
        var originalProducts = productsElements.stream().map(WebElement::getText).collect(Collectors.toList());
        var sorted = originalProducts.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(originalProducts,sorted);
        driver.quit();


    }
}
