import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class HelloSeleniumTest {

    @BeforeClass
    public static void setupClass() {
       // WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();

    }

    @Test
    public void firstTest() throws InterruptedException {
      //  System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new EdgeDriver();
        //driver.get("https://www.saucedemo.com/");
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        Thread.sleep(5000);
        driver.quit();
    }

}
