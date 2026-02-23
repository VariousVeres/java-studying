package inside_project.tests;

import inside_project.pages.DooLoginPage;
import org.testng.annotations.Test;


public class DooLoginTest extends BaseTest{


    @Test
    public void login() {
        DooLoginPage dooLoginPage = new DooLoginPage(getDriver());
        dooLoginPage.enterLogin();
        dooLoginPage.enterPassword();
        dooLoginPage.submitLogin();
    }





}
