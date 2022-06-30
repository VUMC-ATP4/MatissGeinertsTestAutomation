package classroomSeven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;

import java.time.Duration;
import java.util.List;

public class SeleniumTest {
    WebDriver driver;
    WebDriverWait wait;
    public final String SAUCELABS_URL = "https://www.saucedemo.com/";


    @BeforeMethod
    public void setupBrowser(){
        System.out.println("Pirms");
        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void localHTMLExerciseTest() throws InterruptedException {
        driver.get("file://C:\\Users\\matis\\Desktop\\JAVA\\MatissGeinertsTestAutomation\\src\\test\\resources\\elements.html");
        WebElement descriptionTextArea = driver.findElement(By.name("description"));
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys("Šis ir texts par mani. hello hello");
        WebElement linkElements = driver.findElement(By.linkText("Link Text"));
        linkElements.click();
        WebElement isStudentCheckbox = driver.findElement(By.id("studentID"));
        Assert.assertEquals(isStudentCheckbox.isSelected(), false);
        isStudentCheckbox.click();
        Assert.assertEquals(isStudentCheckbox.isSelected(), true);
        Select milakaKrasa = new Select(driver.findElement(By.id("colorsID")));
        milakaKrasa.selectByIndex(0);
        milakaKrasa.selectByIndex(3);

        List<WebElement> sarakstsArKrasam =  milakaKrasa.getOptions();
        for (int i = 0; i < sarakstsArKrasam.size(); i++) {
            System.out.println(sarakstsArKrasam.get(i).getText());
        }
        WebElement nospiedManiPoga = driver.findElement(By.id("checkDataID"));
        nospiedManiPoga.click();


        WebElement vissIrLabiText = driver.findElement(By.id("checkDataResultID"));
//        wait.until(ExpectedCondition.elementToBeClickable(vissIrLabiText));
        vissIrLabiText.click();



    }

    @Test
    public void successfullLoginTest() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("standard_user");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        WebElement pageTitleText = driver.findElement(By.cssSelector("div[id='header_container'] span[class='title']"));
        Assert.assertEquals(pageTitleText.getText(), "PRODUCTS");
        Select sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
        sortDropdown.selectByValue("lohi");
        Thread.sleep(5000);
        sortDropdown = new Select(driver.findElement(By.cssSelector("select[data-test='product_sort_container']")));
        sortDropdown.selectByIndex(1);
        Thread.sleep(5000);


    }
    @Test
    public void successLoginPageObject() {
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");
        inventoryPage.getLinkedInLink().click();
        inventoryPage.getFacebookLink().click();
        inventoryPage.getTwitterLink().click();
        Assert.assertEquals(inventoryPage.getCopyRightText().getText(),
                "© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");


    }

    @Test
    public void errorMessagePasswordEmptyPageObjectTest(){
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Matiss", "");
        loginPage.getErrorText().getText();
        Assert.assertEquals(loginPage.getErrorText().getText(), "Epic sadface: Password is required");
    }



    @Test
    public void errorMessagePasswordEmptyTest() throws InterruptedException {
        System.out.println("Tests");
        driver.get(SAUCELABS_URL);
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("Matiss");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
        errorText.getText();
        System.out.println(errorText.getText());
        Assert.assertEquals(errorText.getText(), "Epic sadface: Password is required");

    }

    @Test
    public void errorMessageUsernameEmptyTest() throws InterruptedException {
        System.out.println("Tests");
        driver.get(SAUCELABS_URL);
//        WebElement acceptedUsernamesText = driver.findElement(By.xpath("//div[@id='login_credentials']//h4"));
//        System.out.println(acceptedUsernamesText.getText());
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("qwerty123");
        WebElement loginButton = driver.findElement(By.className("submit-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
        errorText.getText();
        System.out.println(errorText.getText());
        Assert.assertEquals(errorText.getText(), "Epic sadface: Username is required");

    }

    @Test
    public void errorMessageUsernamePasswordEmptyTest() throws InterruptedException {
        System.out.println("Tests");
        driver.get(SAUCELABS_URL);
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
        errorText.getText();
        System.out.println(errorText.getText());
        Assert.assertEquals(errorText.getText(), "Epic sadface: Username is required");

    }

    @Test
    public void errorMessageWrongCredentialsTest() throws InterruptedException {
        System.out.println("Tests");
        driver.get(SAUCELABS_URL);
        WebElement userNameInputField = driver.findElement(By.id("user-name"));
        userNameInputField.sendKeys("Parole");
        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("Parole");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        WebElement errorText = driver.findElement(By.cssSelector("h3[data-test='error']"));
        errorText.getText();
        System.out.println(errorText.getText());
        Assert.assertEquals(errorText.getText(), "Epic sadface: Username and password " +
                "do not match any user in this service");

    }







    @AfterMethod
    public void tearDownBrowser(){
        System.out.println("Pēc");
        driver.close();

    }

}
