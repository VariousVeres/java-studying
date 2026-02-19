package inside_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactoryTemplateMethod {
    public static WebDriver manageDriver(String browser) {
        DriverOrganizer driverOrganizer = null;
        if (browser != null) {
            if (browser.equalsIgnoreCase("chrome")) {
                driverOrganizer = new ChromeManager();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driverOrganizer = new FirefoxManager();
            } else
                throw new IllegalArgumentException("Wrong browser name");
        }
        return driverOrganizer.getDriver();
    }


}



//abstract
abstract class DriverOrganizer {

    private WebDriver driver;

    final WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    abstract WebDriver createDriver();
}


class ChromeManager extends DriverOrganizer {
    WebDriver createDriver() {
        return new ChromeDriver();
    }
}

class FirefoxManager extends DriverOrganizer {
    WebDriver createDriver() {
        return new FirefoxDriver();
    }
}
