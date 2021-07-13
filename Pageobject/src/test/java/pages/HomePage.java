package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    By navigationItems = By.cssSelector("ds2-navigation-item");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openModelsPage(){
        var button = driver.findElements(navigationItems).stream().filter(
                e -> e.getAttribute("title").equalsIgnoreCase("modele")
        ).findFirst();
        button.ifPresent(WebElement::click);
        driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/span[2]")).click();
    }
}
