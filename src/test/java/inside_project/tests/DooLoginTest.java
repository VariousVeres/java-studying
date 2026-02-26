package inside_project.tests;

import inside_project.pages.DashboardPage;
import inside_project.pages.DooLoginPage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.MatcherAssert.assertThat;


public class DooLoginTest extends BaseTest{


    @Test
    public void login() {
        DooLoginPage dooLoginPage = new DooLoginPage(getDriver());
        dooLoginPage.enterLogin();
        dooLoginPage.enterPassword();
        DashboardPage dashboardPage = dooLoginPage.submitLogin();
        assertThat("Shopping cart is not empty", getDriver().getCurrentUrl(), endsWith("dashboard"));
    }





}
