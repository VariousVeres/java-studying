package inside_project;

import org.openqa.selenium.WebDriver;


public class BasePage {

    private WebDriver webDriver;

    protected BasePage(WebDriver driver) {
        webDriver = driver;
    }

    public WebDriver getDriver()  {
        return webDriver;
    }


}
