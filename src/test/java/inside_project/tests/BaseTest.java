package inside_project.tests;

import inside_project.DriverFactoryTemplateMethod;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeClass
    public void setDriver() {
        driver.set(DriverFactoryTemplateMethod.manageDriver("chrome"));
        getDriver().manage().window().maximize();
        getDriver().navigate().to(System.getProperty("base_url")+ "/account/login");
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterClass
    public void quitDriver() {
        driver.get().quit();
        driver.remove();
    }

}
