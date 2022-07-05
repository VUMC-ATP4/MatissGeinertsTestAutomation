package pageObjects.homeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {
    public WebDriver driver;
    private By finishButton = By.id("finish");
    private By completeText = By.cssSelector("div[class='checkout_complete_container'] h2");
    private By backToHomeButton = By.id("back-to-products");

    public CheckoutSuccessPage(WebDriver driver){
    this.driver = driver;
    }
    public WebElement getFinishButton(){
        return driver.findElement(finishButton);
    }
    public WebElement getCompleteText(){
        return driver.findElement(completeText);
    }
    public WebElement getBackToHomeButton(){
        return driver.findElement(backToHomeButton);
    }
}


