package xamples.java_8;

import org.junit.Test;

/**
 * ПОСИЛАННЯ НА МЕТОД (ЗАМІСТЬ ЛЯМБДИ) ЯК ПАРАМЕТР МЕТОДУ
 **/

interface Inhisfaced {
    void method(int a, int b, String str);
}

interface Inherfaced {
    void method2(String str1, String str2);
}

//Є клас з методом, з такими самим вхід вихід як в методі інтерфейсу, він підходить для його реалізації
class HelpClass {
    static void summ(int a, int b, String str) {
        System.out.println(a + b + " " + str);
    }

    static void concat(String str1, String str2) {
        System.out.println(str1 + " " + str2);
    }
}

public class Lambdas3 {
    static void method1(Inhisfaced ihf) {
        ihf.method(2, 3, "asdasd");
    }

    static void method2(Inherfaced ihef) {
        ihef.method2("Vasya", "Kolya");
    }

    @Test
    public void print() {
        /**Замість лямбди можем юзати метод, який в нас є в окремому класі і який повертає і приймає ті ж типи**/
        Lambdas3.method1(HelpClass::summ);
        Lambdas3.method2(HelpClass::concat);
        /**Або стабільно юзати лямбду**/
        Inhisfaced ifh = (a, b, str) -> System.out.println(a + b + " " + str);
        Inherfaced iheh = (str1, str2) -> System.out.println(str1 + " 777 " + str2);
        Lambdas3.method1(ifh);
        Lambdas3.method2(iheh);
        /**Або підставляти лямбду на льоту**/
        Lambdas3.method1((a, b, str) -> System.out.println("666"));
        Lambdas3.method2((Sstr1, str2) -> System.out.println("888"));

    }
}
