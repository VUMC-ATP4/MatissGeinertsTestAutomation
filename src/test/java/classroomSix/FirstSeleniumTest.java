package classroomSix;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    @Test
    public void checkPageTitle(){
        String URL = "https://www.saucedemo.com/";
        WebDriver browser = new ChromeDriver();
        browser.get(URL);
        String expectedTitle = "Swag Labs";
        String actualTitle = browser.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        browser.quit();
    }

}
