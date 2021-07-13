import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class E2e {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\p-jrm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//a[contains(text(),'Bhopal (BHO)')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='HYD']")).click();
        driver.findElement(By.cssSelector("ui-state-default ui-state-highlight ui-state-active")).click();
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        if(driver.findElement(By.id("Dvi1")).getAttribute("style").contains("0,5")){
            Assert.assertTrue(true);
        }else {
            Assert.fail();
        }
        driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

    }
}
