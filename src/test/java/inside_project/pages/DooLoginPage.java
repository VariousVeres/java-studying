package inside_project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DooLoginPage extends BasePage{
    public DooLoginPage(WebDriver driver) {
        super(driver);
    }

    private final By loginInput = By.cssSelector("input[data-test='username']");
    private final By passwordInput = By.cssSelector("input[data-test='password']");
    private final By submitButton = By.xpath("//input[@type='submit']");



    public void enterLogin()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginInput));
        webDriver.findElement(loginInput).sendKeys("standard_user");
    }

    public void enterPassword() {
        webDriver.findElement(passwordInput).sendKeys("secret_sauce");
    }

    public void submitLogin()  {
        webDriver.findElement(submitButton).click();
    }


}
