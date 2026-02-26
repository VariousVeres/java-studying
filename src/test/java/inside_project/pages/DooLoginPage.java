package inside_project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DooLoginPage extends BasePage{
    public DooLoginPage(WebDriver driver) {
        super(driver);
    }

    private final By loginInput = By.cssSelector("input#email");
    private final By passwordInput = By.cssSelector("input#password");
    private final By submitButton = By.cssSelector("button.btn-blue");
    private final By dashboardRoot = By.xpath("//vv-manager-master");



    public void enterLogin()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginInput));
        driver.findElement(loginInput).sendKeys("oleksandr.veresiuk@eleks.com");
    }

    public void enterPassword() {
        driver.findElement(passwordInput).sendKeys("azAZ09@");
    }


    public DashboardPage submitLogin()  {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        driver.findElement(submitButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardRoot));
        if (isElementPresent(dashboardRoot)) {
            return new DashboardPage(driver);
        } else {
            throw new IllegalStateException("Login failed");
        }
    }


}
