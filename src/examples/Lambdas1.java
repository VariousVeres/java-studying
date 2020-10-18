package examples;

import org.junit.Test;

/**
 * Імплементація для інтерфейсу класичними способами і лямбдами
 **/

/**
 * Наш інтерфес з методом без параметрів
 **/
interface Inyourface {
    void method();
}

/**
 * Створюєм клас для одної імплементації
 **/
class InyourfaceImpl implements Inyourface {
    public void method() {
        System.out.println("Звичайна імплементація 1");
    }
}

/**
 * Створюєм клас для другої імплементації
 **/
class InyourfaceImpl2 implements Inyourface {
    @Override
    public void method() {
        System.out.println("Звичайна імплементація 2");
    }
}

public class Lambdas1 {
    /**
     * Імплементуєм через анонімний клас на льоту
     **/
    Inyourface anonim = new Inyourface() {
        @Override
        public void method() {
            System.out.println("Імплементація через анонімний клас");
        }
    };

    InyourfaceImpl usual1 = new InyourfaceImpl();
    InyourfaceImpl2 usual2 = new InyourfaceImpl2();

    @Test
    public void print1() {
        /**Викликаєм той самий метод, але імплементований по різному**/
        anonim.method();
        usual1.method();
        usual2.method();
    }

    /**Створюєм імплементацію через лямбди**/
    Inyourface lambda1 = () -> System.out.println("Імплементація через лямбду 1");
    Inyourface lambda2 = () -> System.out.println("Імплементація через лямбду 2");

    @Test
    public void print2() {
        lambda1.method();
        lambda2.method();
    }


}










