import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CheckboxesPractice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\p-jrm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        Thread.sleep(3000);
        var checkbox = checkboxes.get(0);

        checkbox.click();
        Assert.assertTrue(checkbox.isSelected());
        checkbox.click();
        Assert.assertFalse(checkbox.isSelected());
        System.out.println(checkboxes.size());
    }
}
