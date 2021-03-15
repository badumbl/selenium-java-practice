package locating.element;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LocatingElementsTest {
    WebDriver driver;

    @Before
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void elemntsQuiz1(){

        driver.get("https://www.saucedemo.com");
        driver.findElement(By.name("user-name"));
    }

    @Test
    public void cssSelectors(){
        driver.get("https://www.saucedemo.com");
        //css ID
        driver.findElement(By.cssSelector("#user-name"));
        //Input element with class form_input
        driver.findElement(By.cssSelector("input.form_input"));
        //direct child
        driver.findElement(By.cssSelector("form>input"));
        //using attributes. Input with id='user-name'
        driver.findElement(By.cssSelector("input[id='user-nmame']"));
    }
    @Test
    public void xPathSelectors(){
        driver.get("https://www.saucedemo.com");
        //xPath
        driver.findElement(By.xpath("//*[@id=\"password\"]"));
    }

}
