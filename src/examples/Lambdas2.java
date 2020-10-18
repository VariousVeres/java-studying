package examples;

import org.junit.Test;

/**
 * Наш інтерфес з методом з двома int параметрами, який повертає int
 **/
interface Inmyface {
    int method(int a, int b, String str);
}

public class Lambdas2 {
    /**
     * Створюєм різні імплементації через різні лямбди
     **/
    Inmyface lambda1 = (int a, int b, String str) -> {
        System.out.println(str + " " + (a + b));
        return a + b;
    };

    Inmyface lambda2 = (int a, int b, String str) -> {
        System.out.println(a * b + " - " + str);
        return a / b;
    };

    @Test
    public void print() {
        lambda1.method(2, 3, "Кількість баскетболістів");
        lambda2.method(2, 3, "кількість баскетболістів");
    }

}
