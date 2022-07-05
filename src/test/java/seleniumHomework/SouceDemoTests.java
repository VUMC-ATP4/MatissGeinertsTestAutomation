package seleniumHomework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.homeworkSelenium.*;

public class SouceDemoTests {
    WebDriver driver;
    public final String SAUCELABS_URL = "https://www.saucedemo.com/";
    @BeforeMethod
    public  void setupBrowser(){
        System.out.println("Pirms testa");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // 1. Scenārijs

    @Test
    public void successLoginTest() {
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");
        Assert.assertEquals(inventoryPage.getCopyRightText().getText(),
                "© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
    }

    @Test
    public void addProductToCartTest() {
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        CartPage cartPage = new CartPage(driver);
        cartPage.getAddToCartButton().click();
        cartPage.getShoppingCart().click();
        Assert.assertEquals(cartPage.getCartPageTitle().getText(), "YOUR CART");

        }

    @Test
    public void checkOutPageTest() {
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        CartPage cartPage = new CartPage(driver);
        cartPage.getAddToCartButton().click();
        cartPage.getShoppingCart().click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getCheckoutButton().click();
        Assert.assertEquals(checkoutPage.getCheckoutPageTitle().getText(), "CHECKOUT: YOUR INFORMATION");


    }

    @Test
    public void checkoutOverviewPageTest() {
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        CartPage cartPage = new CartPage(driver);
        cartPage.getAddToCartButton().click();
        cartPage.getShoppingCart().click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getCheckoutButton().click();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.checkout("Matīss", "Geinerts","LV3001");
        Assert.assertEquals(checkoutOverviewPage.getOverviewPageTitle().getText(), "CHECKOUT: OVERVIEW");

    }

    @Test
    public void checkoutSuccessPageTest() throws InterruptedException {
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        CartPage cartPage = new CartPage(driver);
        cartPage.getAddToCartButton().click();
        cartPage.getShoppingCart().click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getCheckoutButton().click();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.checkout("Matīss", "Geinerts","LV3001");
        CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
        checkoutSuccessPage.getFinishButton().click();
        Assert.assertEquals(checkoutSuccessPage.getCompleteText().getText(), "THANK YOU FOR YOUR ORDER");
        checkoutSuccessPage.getBackToHomeButton().click();
        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertEquals(inventoryPage.getPageTitle().getText(), "PRODUCTS");



    }

    // 2. scenārijs

    @Test
    public void errorMessageFirstNameLastNameZipCodeEmptyTest(){
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        CartPage cartPage = new CartPage(driver);
        cartPage.getShoppingCart().click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getCheckoutButton().click();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.checkout("", "","");
        ErrorTexts errorTexts = new ErrorTexts(driver);
        System.out.println(errorTexts.getErrorText().getText());
        Assert.assertEquals(errorTexts.getErrorText().getText(), "Error: First Name is required");

    }

    @Test
    public void errorMessageLastNameEmptyTest(){
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        CartPage cartPage = new CartPage(driver);
        cartPage.getShoppingCart().click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getCheckoutButton().click();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.checkout("Matīss", "","LV3001");
        ErrorTexts errorTexts = new ErrorTexts(driver);
        System.out.println(errorTexts.getErrorText().getText());
        Assert.assertEquals(errorTexts.getErrorText().getText(), "Error: Last Name is required");

    }

    @Test
    public void errorMessageFirstNameEmptyTest(){
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        CartPage cartPage = new CartPage(driver);
        cartPage.getShoppingCart().click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getCheckoutButton().click();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.checkout("", "Geinerts","LV3001");
        ErrorTexts errorTexts = new ErrorTexts(driver);
        System.out.println(errorTexts.getErrorText().getText());
        Assert.assertEquals(errorTexts.getErrorText().getText(), "Error: First Name is required");

    }

    @Test
    public void errorMessageZipCodeEmptyTest(){
        driver.get(SAUCELABS_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");
        CartPage cartPage = new CartPage(driver);
        cartPage.getShoppingCart().click();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.getCheckoutButton().click();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.checkout("Matiss", "Geinerts","");
        ErrorTexts errorTexts = new ErrorTexts(driver);
        System.out.println(errorTexts.getErrorText().getText());
        Assert.assertEquals(errorTexts.getErrorText().getText(), "Error: Postal Code is required");

    }







    @AfterMethod
    public  void tearDownBrowser(){
        System.out.println("Testa Beigas");
        driver.close();
    }

}
