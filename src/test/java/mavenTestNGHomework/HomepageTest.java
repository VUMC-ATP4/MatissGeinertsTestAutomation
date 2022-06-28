package mavenTestNGHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomepageTest {

    @Test

    public void checkHomepageTitle(){
        String url = "https://translate.google.com/";
        WebDriver browser = new ChromeDriver();
        browser.get(url);
        String expectedTitle = "Google Translate";
        String actualTitle = browser.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        browser.quit();
    }
    @Test
    public void checkHomepageTitle1(){
        String url = "https://www.ss.com/";
        WebDriver browser = new ChromeDriver();
        browser.get(url);
        String expectedTitle = "Sludinājumi - SS.COM";
        String actualTitle = browser.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        browser.quit();
    }


}
