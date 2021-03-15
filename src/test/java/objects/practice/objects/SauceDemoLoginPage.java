package objects.practice.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceDemoLoginPage {


    private final WebDriver driver;
    private WebElement userNameField;
    private WebElement passwordField ;
    private WebElement loginButton;


    public SauceDemoLoginPage(WebDriver driver) {
        this.driver = driver;
        this.userNameField = driver.findElement(By.id("user-name"));
        this.passwordField = driver.findElement(By.id("password"));
        this.loginButton = driver.findElement(By.id("login-button"));
    }

    public void logIn(String username, String password) {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
