import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\p-jrm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']"));
        Assert.assertFalse(checkBox.isSelected());
       checkBox.click();
        Thread.sleep(3000);
        Assert.assertTrue(checkBox.isSelected());



        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        //count number of checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        Assert.assertEquals(6,checkboxes.size());
        driver.close();
    }
}
