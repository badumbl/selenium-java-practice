package objects.practice;

import objects.practice.objects.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ObjectTests {

    private SauceDemoLoginPage loginPage;
    private ProductsPage productsPage;
    private HeaderObject headerObject;
    private ShoppingCartObject shoppingCartObject;
    private CheckoutObject checkoutObject;
    private WebDriver driver;

    @Before
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        loginPage = new SauceDemoLoginPage(driver);
        productsPage = new ProductsPage(driver);
        headerObject = new HeaderObject(driver);
        shoppingCartObject = new ShoppingCartObject(driver);
        checkoutObject = new CheckoutObject(driver);
    }

    @After
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void testLogin() throws InterruptedException {
        loginPage.logIn("standard_user", "secret_sauce");
        Thread.sleep(1000);
    }

    @Test
    public void testAddingItemToCart() throws InterruptedException {
        testLogin();
        productsPage.addToCart("//*[@id='inventory_container']/div/div[1]/div[3]/button");
        Thread.sleep(1000);
    }

    @Test
    public void testGoToCart() throws InterruptedException {
        testAddingItemToCart();
        headerObject.goToShoppingCart();
        Thread.sleep(1000);
    }

    @Test
    public void goToCheckout() throws InterruptedException {
        testGoToCart();
        shoppingCartObject.checkOut();
        Thread.sleep(1000);
    }

    @Test
    public void checkoutForm() throws InterruptedException {
        goToCheckout();
        checkoutObject.fillInForm("Test", "Name", "12345");
        Thread.sleep(1000);
        checkoutObject.pressContinue();
        Thread.sleep(1000);
    }

}
