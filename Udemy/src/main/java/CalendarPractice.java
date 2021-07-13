import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarPractice {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\p-jrm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        // second window is opening by default
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[3]/a[1]")).click();
        //System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        //System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"));
    }
}
