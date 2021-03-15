package cookies.practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Date;

public class CookiesPractice {

    @Test
    public void cookiesPractice() {
        System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://example.com");

        Cookie cookie = new Cookie.Builder("name", "value")
                .domain("example.com")
                .expiresOn(new Date(2020, 10, 31))
                .isHttpOnly(true)
                .isSecure(false)
                .path("/mypath")
                .build();

        driver.manage().addCookie(cookie);
        driver.get("http://example.com/mypath");

        Cookie found = driver.manage().getCookieNamed("name");
        Assert.assertEquals("value", found.getValue());
        driver.manage().deleteAllCookies();

        Assert.assertFalse(driver.manage().getCookies().contains(found));
    }

}
