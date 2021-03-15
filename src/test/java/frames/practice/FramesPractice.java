package frames.practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesPractice {

    @Test
    public void switchFrames() {
        System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/nested_frames");

        //WebElement defaultFrame = driver.findElement(By.name("frame-top"));

        //switch frames by index. 0 is first, etc.
        driver.switchTo().frame(1);

        Assert.assertEquals("BOTTOM", driver.findElement(By.tagName("body")).getText());

        //switch frames by frame-name and parent frame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        Assert.assertEquals("LEFT", driver.findElement(By.tagName("body")).getText());
        //move to the top most/default frame
        driver.switchTo().defaultContent();
        Assert.assertTrue(driver.findElement(By.name("frame-top")).getSize().height > 0);
        driver.quit();
    }
}
