package inside_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class DooLoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setDriver() {
        driver = DriverFactoryTemplateMethod.manageDriver("chrome");
        driver.get("https://staging1.doo.net/account/login");
    }

    @Test
    public void login() {
        DooLoginPage dooLoginPage = new DooLoginPage(driver);
        dooLoginPage.enterLogin();
        dooLoginPage.enterPassword();
        dooLoginPage.submitLogin();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(e-> e.getCurrentUrl().contains("dashboard"));


        System.out.println(dooLoginPage.toString());
    }


    @AfterClass
    void quitDriver() {
        driver.quit();
    }


}
