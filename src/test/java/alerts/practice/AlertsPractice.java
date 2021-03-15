package alerts.practice;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsPractice {

    @Test
    public void alertPractice() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","resources/windows/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        //normalize-space removes additional spaces between words
        driver.findElement(By.xpath("//*[contains(normalize-space(text()),'Click for JS Alert')]")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("//*[contains(normalize-space(text()),'Click for JS Confirm')]")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//*[contains(normalize-space(text()),'Click for JS Prompt')]")).click();
        Thread.sleep(1000);
        Alert inputText = driver.switchTo().alert();
        inputText.sendKeys("Test alert text input");
        Thread.sleep(1000);
        inputText.accept();
        Thread.sleep(2000);

        driver.close();
    }

}
