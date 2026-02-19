package xamples.generics.neww;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GenericBoundedMethod {

    private static <T extends WebDriver> T method(T value) {
        return value;
    }

    private static WebDriver badMethod(WebDriver driver) {
        return driver;
    }


    @Test
    public void test()  {
        ChromeDriver chromeDriver = method(new ChromeDriver());
        FirefoxDriver firefoxDriver = method(new FirefoxDriver());
        chromeDriver.quit();
        firefoxDriver.quit();
    }
}
