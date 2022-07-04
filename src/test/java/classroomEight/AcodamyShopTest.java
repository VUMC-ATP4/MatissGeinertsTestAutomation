package classroomEight;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.AcodamyShop.MainPage;
import pageObjects.InventoryPage;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AcodamyShopTest {
    WebDriver driver;
    WebDriverWait wait;
    public final String ACODAMY_SHOP_URL = "http://shop.acodemy.lv/";

    @BeforeMethod
    public void setupBrowser() throws MalformedURLException {
        System.out.println("Pirms");
//        driver = new ChromeDriver();

        ChromeOptions chromeOptions = new ChromeOptions();
//     chromeOptions.setCapability("browserVersion", "103");
        chromeOptions.setCapability("platformName", "Windows");
        chromeOptions.setCapability("se:name", "My simple test");
        driver = new RemoteWebDriver(new URL("http://84.237.169.194:4444/"), chromeOptions);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void searchForItemTest(){
        driver.get(ACODAMY_SHOP_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("a");
        System.out.println("Search result count: " + mainPage.getSearchResults().size());
        Assert.assertEquals(mainPage.getSearchResults().size(), 10);
        List<WebElement> searchResults = mainPage.getSearchResults();
        for (WebElement element : searchResults) {
            System.out.println(element.findElement(By.cssSelector("h2")).getText());
            System.out.println(element.findElement(By.className("price")).getText());


        }


        System.out.println("DEBUG LINE");

    }

    @Test
    public void searchForItemTest2(){
        driver.get(ACODAMY_SHOP_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct("Hoodie");
        System.out.println("Search result count: " + mainPage.getSearchResults().size());
        Assert.assertEquals(mainPage.getSearchResults().size(), 2);

        System.out.println("DEBUG LINE");

    }

    @Test
    public void switchTabTest(){
        driver.get("https://www.w3schools.com/");
        System.out.println("Atverti tabi: " + driver.getWindowHandles().size());
        driver.findElement(By.id("accept-choices")).click();
        driver.findElement(By.cssSelector("a[title='W3Schools on LinkedIn']")).click();
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(tabs.get(0));
        System.out.println(driver.getTitle());
        System.out.println("Atverti tabi: " + driver.getWindowHandles().size());
        System.out.println();



    }

    @Test
    public void javaScriptExecutorExampleTest() throws InterruptedException {
        driver.get("https://www.lu.lv/");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[id='ccm__footer__consent-bar-submit']")).click();
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,3000)");
        Thread.sleep(2000);
        driver.findElement(By.className("footer__up")).click();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.linkText("Kontakti"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);


    }

    @Test
    public void hoverTest(){
        driver.get("https://www.w3schools.com/howto/howto_css_dropdown.asp");
        driver.findElement(By.id("accept-choices")).click();
        WebElement element = driver.findElement(By.cssSelector("div.dropdown2 button"));
        new Actions(driver).moveToElement(element).perform();
        driver.findElement(By.linkText("Link 1")).click();
    }
    @Test
    public void keyboardClickTest() throws InterruptedException {

        driver.get("https://www.microsoft.com/applied-sciences/projects/anti-ghosting-demo");
        driver.findElement(By.id("clickToUseButton")).click();
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .keyDown(Keys.ALT)
                .perform();
        Thread.sleep(5000);

       new Actions(driver)
                .keyUp(Keys.ALT)
                .perform();

        Thread.sleep(5000);


    }

    @Test
    public void seleniumDocTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/documentation/");
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("k")
                .perform();
        Thread.sleep(5000);

    }





    @AfterMethod
    public void tearDownBrowser(){
        System.out.println("Pēc");
        driver.close();

    }
}
