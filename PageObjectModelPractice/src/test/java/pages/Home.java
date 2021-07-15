package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Home extends BasePage {
    private final int SCROLL_FOR_FEATUED_ITEMS = 800;

    public Home() {
        super();
    }

    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInButton;
    @FindBy(xpath = "//ul[@id='homefeatured']/li/div")
    List<WebElement> featuredProducts;


    public SignIn goToSignInPage() {
        signInButton.click();
        return new SignIn();
    }

    public Home addFeaturedItemsToBasket() throws InterruptedException {

        js.executeScript(String.format("window.scrollBy(0,%d)", SCROLL_FOR_FEATUED_ITEMS));
        for (WebElement featuredProduct : featuredProducts) {

            actions.moveToElement(featuredProduct)
                    .build().perform();

            WebElement addToCard = featuredProduct.findElement(By.xpath("//div[1]/div[2]/div[2]/a[1]"));
            System.out.println(addToCard.getText());
            actions.moveToElement(addToCard)
                    .click().build().perform();


            Thread.sleep(5000);
            var continueShoppingButton = driver.findElement(By.xpath("//span[@title='Continue shopping']"));
            actions.moveToElement(continueShoppingButton)
                    .click().build().perform();
            Thread.sleep(4000);

        }
        return this;
    }
}
