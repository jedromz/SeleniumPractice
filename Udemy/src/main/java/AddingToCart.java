import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.IntStream;

public class AddingToCart {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\p-jrm\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.manage().window().maximize();

        List<WebElement> products = driver.findElements(By.className("h4.product-name"));
        var searchedProducts = new String[]{"Cucumber","Broccoli"};
        addItemsToCart(driver, products,searchedProducts);
    }

    private static void addItemsToCart(WebDriver driver, List<WebElement> products,String[] searchedProducts) {
        for (String product : searchedProducts) {
            var buttonIndexOptional = IntStream.range(0, products.size())
                    .filter(i-> products.get(i).getText().contains(product))
                    .findFirst();
            if(buttonIndexOptional.isPresent()){
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(buttonIndexOptional.getAsInt()).click();
            }
        }

    }
}
