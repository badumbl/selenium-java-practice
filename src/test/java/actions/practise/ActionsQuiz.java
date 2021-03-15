package actions.practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionsQuiz {
    WebDriver driver;

    @Before
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @After
    public void cleanUp(){
        driver.quit();
    }

    @Test
    public void actionTestDropDown() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownButton = driver.findElement(By.id("dropdown"));
        dropdownButton.click();
        WebElement dropdownButtonOption1 = dropdownButton.findElement(By.xpath("//*[@value=1]"));
        WebElement dropdownButtonOption2 = dropdownButton.findElement(By.xpath("//*[@value=2]"));
        dropdownButtonOption1.click();
        Assert.assertTrue(dropdownButtonOption1.isSelected());
        Assert.assertFalse(dropdownButtonOption2.isSelected());

    }
    @Test
    public void actionTestHover(){
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement firstIcon = driver.findElement(By.xpath("//*[@class='figure']/img"));
        Actions action = new Actions(driver);
        action.moveToElement(firstIcon).perform();
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), 'name: user1')]"));
        Assert.assertTrue(element.isDisplayed());

    }
    @Test
    public void actionTestRightClick(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement element = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.contextClick(element).perform();
        driver.switchTo().alert().accept();

    }
    @Test
    public void actionTestKeyPress(){
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement target = driver.findElement(By.id("target"));
        target.click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_RIGHT).perform();
        WebElement element = driver.findElement(By.id("result"));
        Assert.assertTrue(element.isDisplayed());

    }
    @Test
    public void actionTestGetValue(){
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        WebElement element = driver.findElement(By.linkText("Clickable Icon"));
        Assert.assertEquals("https://ultimateqa.com/link-success/", element.getAttribute("href"));
        Assert.assertEquals("padding-box", element.getCssValue("background-origin"));

    }
}
