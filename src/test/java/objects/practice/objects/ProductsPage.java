package objects.practice.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart(String name){
        driver.findElement(By.xpath(name)).click();
    }
}
