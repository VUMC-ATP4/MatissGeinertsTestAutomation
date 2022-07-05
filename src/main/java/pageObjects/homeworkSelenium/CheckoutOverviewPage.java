package pageObjects.homeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {
    public WebDriver driver;
    private By firstNameInputField = By.id("first-name");
    private By lastNameInputField = By.id("last-name");
    private By zipCodeInputField = By.id("postal-code");
    private By continueButton = By.id("continue");

    private By overviewPageTitle = By.cssSelector("div[id='header_container'] span[class='title']");

    public CheckoutOverviewPage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getOverviewPageTitle(){
        return driver.findElement(overviewPageTitle);
    }
    public WebElement getContinueButton(){
        return driver.findElement(continueButton);
    }
    public WebElement getFirstNameInputField(){
        return driver.findElement(firstNameInputField);
    }
    public WebElement getLastNameInputField(){
        return driver.findElement(lastNameInputField);
    }
    public WebElement getZipCodeInputField(){
        return driver.findElement(zipCodeInputField);
    }

    public void checkout(String firstName, String lastName, String zipCode){
        getFirstNameInputField().sendKeys(firstName);
        getLastNameInputField().sendKeys(lastName);
        getZipCodeInputField().sendKeys(zipCode);
        getContinueButton().click();
    }


}
