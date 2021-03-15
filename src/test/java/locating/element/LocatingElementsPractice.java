package locating.element;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LocatingElementsPractice {

    WebDriver driver;

    @Before
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void locatingPractice(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");

        //login page
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        //add to cart + finish to checkout
        driver.findElement(By.cssSelector("#inventory_container > div > div:nth-child(1) > div.pricebar > button")).click();
        driver.findElement(By.cssSelector("#shopping_cart_container")).click();
        driver.findElement(By.cssSelector(".btn_action.checkout_button")).click();

        //fill out customer info
        driver.findElement(By.id("first-name")).sendKeys("first name");
        driver.findElement(By.id("last-name")).sendKeys("last name");
        driver.findElement(By.id("postal-code")).sendKeys("zip");
        driver.findElement(By.xpath("//*[@class='btn_primary cart_button']")).click();

        //finish
        driver.findElement(By.linkText("FINISH")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("#checkout_complete_container")).isDisplayed());

    }

}
