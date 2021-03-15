package execises;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Exercise1 {
    WebDriver driver;
    WebElement element;
    private JavascriptExecutor javascriptExecutor;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void actions() {
        driver.get("https://example.cypress.io/commands/actions");
        driver.findElement(By.cssSelector(".action-focus")).click();
        element = driver.findElement(By.xpath("//*[@for='password1']"));
        Assert.assertTrue(element.getAttribute("style").equals("color: orange;"));

    }

    @Test
    public void cookies() {
        driver.get("https://example.cypress.io/commands/cookies");
        driver.findElement(By.cssSelector(".set-a-cookie.btn.btn-success")).click();
        Cookie cookie = driver.manage().getCookieNamed("token");
        Assert.assertEquals("123ABC", cookie.getValue());
    }

    @Test
    public void scrollToBottom() throws InterruptedException {
        driver.get("https://ultimateqa.com/complicated-page/");
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);
    }

    @Test
    public void scrollToTop() throws InterruptedException {
        driver.get("https://ultimateqa.com/complicated-page/");
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1000);
        javascriptExecutor.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
        Thread.sleep(1000);
    }


}
