package inside_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DooLoginPage extends BasePage{
    public DooLoginPage(WebDriver driver) {
        super(driver);
    }

    private final By loginInput = By.cssSelector("input#email");
    private final By passwordInput = By.cssSelector("input#password");
    private final By submitButton = By.xpath("//div[@class='form-controls vv-mb-lg']/button");



    public void enterLogin()  {
        getDriver().findElement(loginInput).sendKeys("oleksandr.veresiuk@eleks.com");
    }

    public void enterPassword() {
        getDriver().findElement(passwordInput).sendKeys("azAZ09@-");
    }

    public void submitLogin()  {
        getDriver().findElement(submitButton).click();
    }


}
