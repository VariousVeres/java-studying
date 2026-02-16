package xamples.design_patterns.neww;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Ти повинен: мати абстрактний клас DriverCreator
 * <p>
 * в ньому має бути:
 * abstract метод createDriver()
 * не abstract метод getDriver(), який:
 * викликає createDriver()
 * робить додаткову логіку (наприклад maximize)
 * повертає драйвер
 * <p>
 * 5️⃣ Конкретні браузери повинні:
 * наслідувати DriverCreator
 * перевизначати createDriver()
 * 6️⃣ В тесті ти маєш працювати через:
 * DriverCreator creator;
 * WebDriver driver = creator.getDriver();
 **/

//Може бути інтерфейс замість абстрактного класу якщо немає стану
interface DriverManager {
    default WebDriver getDriver()  {
        WebDriver driver = createDriver();
        driver.manage().window().maximize();
        return driver;
    }

    WebDriver createDriver();

}
class Chrome implements DriverManager {

    @Override
    public WebDriver createDriver() {
        return new ChromeDriver();
    }
}

class Firefox implements DriverManager{

    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver();
    }
}



public class FactoryForWebDriver {
    @Test
    public void test() {
        DriverManager creator = new Chrome();
        creator.getDriver();


    }
}
