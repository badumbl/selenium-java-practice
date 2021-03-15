package objects.practice.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutObject {

    WebDriver driver;

    public CheckoutObject(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInForm(String fName, String lName, String zip) {
        driver.findElement(By.id("first-name")).sendKeys(fName);
        driver.findElement(By.id("last-name")).sendKeys(lName);
        driver.findElement(By.id("postal-code")).sendKeys(zip);
    }

    public void pressContinue(){
        driver.findElement(By.cssSelector(".btn_primary.cart_button")).click();
    }
}
