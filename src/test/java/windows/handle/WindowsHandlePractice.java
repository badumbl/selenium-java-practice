package windows.handle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowsHandlePractice {

    @Test
    public void windowChange() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","resources/windows/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://the-internet.herokuapp.com/windows/new');");

        String mainWindow = driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        Iterator<String> it = s.iterator();
        String childWindow;
        while (it.hasNext()){
            childWindow = it.next();
            if(!childWindow.equals(mainWindow)){
                driver.switchTo().window(childWindow);
                Thread.sleep(1000);
                Assert.assertEquals("New Window",driver.getTitle());
                driver.close();
                Thread.sleep(1000);
            }
        }
        driver.quit();

}}
