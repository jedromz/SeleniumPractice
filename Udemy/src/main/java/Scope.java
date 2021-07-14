import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Scope {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\p-jrm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String homePage = "https://rahulshettyacademy.com/AutomationPractice/";
        driver.get(homePage);
        driver.manage().window().maximize();

        //count all links in a footer
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        System.out.println(footer.findElements(By.tagName("a")).size());
        WebElement discountsColumn = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        var links = discountsColumn.findElements(By.tagName("a"));
        int broken = 0;
        int working = 0;
        for (WebElement link : links) {
            var url = link.getAttribute("href");
            if(url == null || url.isEmpty()){
                System.out.println("link empty or not confiugured...");
            }
            try{
                var huc = (HttpURLConnection)(new URL(url)).openConnection();
                huc.setRequestMethod("HEAD");
                huc.connect();
                var responseCode = huc.getResponseCode();
                if(responseCode >= 400){
                    broken++;
                }else {
                    working++;
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("BROKEN: " + broken);
        System.out.println("WORKING: " + working);
    }
}
