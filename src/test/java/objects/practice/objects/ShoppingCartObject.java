package objects.practice.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartObject {

    private WebDriver driver;

    public ShoppingCartObject(WebDriver driver) {
        this.driver = driver;
    }

    public void checkOut(){
        driver.findElement(By.cssSelector(".btn_action.checkout_button")).click();
    }
}
