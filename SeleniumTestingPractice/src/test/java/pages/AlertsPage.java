package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AlertsPage {

    WebDriver driver;
     By infoAlertButton = By.xpath("//button[contains(text(),'alert box:')]");
     By confirmationButton = By.cssSelector("div.container.center:nth-child(2) div.row div.col-md-12 div.nav.nav-tabs div.tab-content div.tab-pane.col-md-6.col-md-offset-1.col-xs-4.col-xs-offset-1.active:nth-child(2) > button.btn.btn-primary:nth-child(1)");
     By promptAlertButton = By.xpath("//button[contains(text(),'click the button to demonstrate the prompt box')]");
     By confirmationAlertLink = By.xpath("//a[contains(text(),'Alert with OK & Cancel')]");
     By promptAlertLink = By.xpath("//a[contains(text(),'Alert with Textbox')]");
     By infoAlertLink = By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickInfoAlertLink(){
        driver.findElement(infoAlertLink).click();
    }
    public void clickPromptAlertLink(){
        driver.findElement(promptAlertLink).click();
    }
    public void clickConfirmationAlertLink(){
        driver.findElement(confirmationAlertLink).click();
    }
    public void clickConfirmationAlertButton(){
        driver.findElement(confirmationButton).click();
    }
    public void clickInfoAlertButton(){
        driver.findElement(infoAlertButton).click();
    }
    public void clickPromptAlertButton(){
        driver.findElement(promptAlertButton).click();
    }
    public void sendDataToPromptAlertAndAccept(Alert alert,String data){
        alert.sendKeys(data);
        alert.accept();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public By getInfoAlertButton() {
        return infoAlertButton;
    }

    public By getConfirmationButton() {
        return confirmationButton;
    }

    public By getPromptAlertButton() {
        return promptAlertButton;
    }

    public By getConfirmationAlertLink() {
        return confirmationAlertLink;
    }

    public By getPromptAlertLink() {
        return promptAlertLink;
    }

    public By getInfoAlertLink() {
        return infoAlertLink;
    }
}
