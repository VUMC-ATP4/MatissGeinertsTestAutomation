package pageObjects.homeworkSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorTexts {
    public WebDriver driver;
    private By errorText = By.cssSelector("h3[data-test='error']");

    public ErrorTexts(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getErrorText(){
        return driver.findElement(errorText);
    }
}
