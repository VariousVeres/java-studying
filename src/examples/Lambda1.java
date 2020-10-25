package examples;

import org.junit.Test;

/****
 ВСТУП ДО ЛЯМБД
 ****/

/**
 * Імплементація для інтерфейсу без параметрів класичними способами і лямбдами
 **/

//Інтерфейс 1 з методом без параметрів//
interface Inyourface {
    void method();
}

//Створюєм клас для одної імплементації інтерфейсу 1//
class InyourfaceImpl implements Inyourface {
    @Override
    public void method() {
        System.out.println("Звичайна імплементація 1");
    }
}

//Створюєм клас для другої імплементації інтерфейсу 1//
class InyourfaceImpl2 implements Inyourface {
    @Override
    public void method() {
        System.out.println("Звичайна імплементація 2");
    }
}

public class Lambda1 {
    //Імплементуєм інтерфейс 1 через анонімний клас на льоту//
    Inyourface anonim = new Inyourface() {
        @Override
        public void method() {
            System.out.println("Імплементація через анонімний клас");
        }
    };
    //Створюєм екземляри класів, які імплементять інтерфейс 1//
    InyourfaceImpl usual1 = new InyourfaceImpl();
    InyourfaceImpl2 usual2 = new InyourfaceImpl2();

    @Test
    public void print1() {
        //Викликаєм той самий метод, але імплементований по різному//
        anonim.method();
        usual1.method();
        usual2.method();
    }

    /**
     * Створюєм імплементацію через лямбди
     **/
    Inyourface lambda1 = () -> System.out.println("Імплементація через лямбду 1");
    Inyourface lambda2 = () -> System.out.println("Імплементація через лямбду 2");

    @Test
    public void print2() {
        lambda1.method();
        lambda2.method();
    }

}

/**
 * Імплементація лямбдами для інтерфейсу з параметрами
 **/

//Інтерфейс 2 з методом з двома int і одним стрінг параметрами, який повертає int//
interface Inmyface {
    int method(int a, int b, String str);
}

class Lambda12 {
    /**
     * Створюєм різні імплементації через різні лямбди
     **/
    Inmyface lambda3 = (a, b, str) -> {
        System.out.println(str + " " + (a + b));
        return a + b;
    };

    Inmyface lambda4 = (a, b, str) -> {
        System.out.println(a * b + " - " + str);
        return a / b;
    };

    @Test
    public void print3() {
        lambda3.method(2, 3, "Кількість баскетболістів");
        lambda4.method(2, 3, "Кількість футболістів");
    }


}










