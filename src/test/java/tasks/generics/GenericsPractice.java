package tasks.generics;

import org.testng.annotations.Test;

/**
 * Generics (Practice): Напиши метод public <T extends BasePage> T createPage(Class<T> pageClass).
 * Це база для динамічного створення сторінок у Selenium. Коли ти сам пропишеш цей дженерик, питання про «вайлдкарди» відпадуть самі собою.
 **/
class BasePage {

}

class LoginPage extends BasePage {
    String k = "Login page";

}

class IntroPage extends BasePage {
    String j = "Intro page";

}

class Zalupa {

}

public class GenericsPractice {

    public <T extends BasePage> T createPage(Class<T> pageClass) {
        try {
            return pageClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(
                    "Cannot create page: " + pageClass.getName(), e
            );
        }
    }

    @Test
    public void test() {
        LoginPage loginPage = createPage(LoginPage.class);
        System.out.println(loginPage.k);
        IntroPage introPage = createPage(IntroPage.class);
        System.out.println(introPage.j);
//        //Отак не піде
//        createPage(Zalupa.class);
    }

}
