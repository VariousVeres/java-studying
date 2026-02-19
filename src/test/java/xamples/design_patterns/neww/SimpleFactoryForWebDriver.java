package xamples.design_patterns.neww;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

import java.util.Optional;

class DriverFactory {
    public static WebDriver getDriver()  {
        //Якщо оформлене просто як хелпер статичний то це дуже сімпл фекторі
       String browser = Optional.ofNullable(System.getProperty("driver")).orElse("chrome");
        if (browser.equals("chrome")) {
            return new ChromeDriver();
        } else if (browser.equals("firefox")) {
            return new FirefoxDriver();
        } else throw new IllegalArgumentException("Wrong argument");
    }
}
public class SimpleFactoryForWebDriver {
    @Test
    public void test()  {
        WebDriver driver = DriverFactory.getDriver();
        driver.quit();
    }
}
