package pageObjects.homeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    public WebDriver driver;

    private By checkoutButton = By.id("checkout");
    private By checkoutPageTitle = By.cssSelector("div[id='header_container'] span[class='title']");
    private By firstNameInputField = By.id("first-name");
    private By lastNameInputField = By.id("last-name");
    private By zipCodeInputField = By.id("postal-code");


    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getCheckoutButton(){
        return driver.findElement(checkoutButton);
    }
    public WebElement getCheckoutPageTitle(){
        return driver.findElement(checkoutPageTitle);
    }





}

