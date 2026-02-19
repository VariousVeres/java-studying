package inside_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public class DooLoginTestThreadLocal {
    private final static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void setDriver() {
        driver.set(DriverFactoryTemplateMethod.manageDriver("chrome"));
        getDriver().get("https://staging1.doo.net/account/login");
    }

    private WebDriver getDriver() {
        return driver.get();
    }

    @Test
    public void login() {
        DooLoginPage dooLoginPage = new DooLoginPage(getDriver());
        dooLoginPage.enterLogin();
        dooLoginPage.enterPassword();
        dooLoginPage.submitLogin();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(e -> e.getCurrentUrl().contains("dashboard"));


        System.out.println(dooLoginPage.toString());
    }


    @AfterMethod
    void quitDriver() {
        getDriver().quit();
        driver.remove();
    }


}
