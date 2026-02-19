package inside_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class DriverFactorySimple {
    public static WebDriver manageDriver(String browser) {
        DriverManager driverManager = null;
        switch (browser) {
            case "chrome":
                driverManager = new ChromeDriverManager();
                break;
            case "firefox":
                driverManager = new FirefoxDriverManager();
                break;
            default:
                throw new IllegalArgumentException("Wrong browser name");
        }
        driverManager.setDriver();
        return driverManager.getDriver();
    }
}

//abstract
abstract class DriverManager {
    protected WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }

    abstract void setDriver();



}


class ChromeDriverManager extends DriverManager {

    public void setDriver() {
        driver = new ChromeDriver();
    }
}

class FirefoxDriverManager extends DriverManager {

    public void setDriver() {
        driver = new FirefoxDriver();
    }
}
