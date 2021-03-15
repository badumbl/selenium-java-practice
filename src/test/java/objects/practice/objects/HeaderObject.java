package objects.practice.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderObject {

    private WebDriver driver;

    public HeaderObject(WebDriver driver) {
        this.driver = driver;
    }

    public void goToShoppingCart(){
        driver.findElement(By.cssSelector("[data-icon='shopping-cart']")).click();
    }

}
