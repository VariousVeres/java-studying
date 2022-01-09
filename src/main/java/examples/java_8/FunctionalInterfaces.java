package examples.java_8;


import org.junit.Test;

import java.util.function.*;

/**
 * ЗАСТОСУВАННЯ Ф-ЦІОНАЛЬНИХ ІНТЕРФЕЙСІВ
 **/

//1)Можем мати отакий інтерфейс з дженерік типами
interface Face1<T> {
    T getValue(T t);
}

//2)Можем мати інший інтерфейс з визначеними типами
interface Face2 {
    boolean getValue(int t);
}

public class FunctionalInterfaces {
    @Test
    public void main() {
        //1)Імплементуєм його через лямбду, вказуєм тип і повертаєм його ж
        Face1<String> face1 = (stringValue) -> stringValue + "  ";
        //2)Так само імплементуєм його через лямбду, типи не потрібно вказувати - приймає інт вертає булін
        Face2 face2 = (intValue) -> intValue > 8;

        /**Є цілий набір вже готових таких інтерфейсів, які можна імпортити і використовувати**/
        //Приймає один тип, повертає boolean
        Predicate<String> pr1 = (t) -> t.startsWith("asd");
        Predicate pr2 = (t) -> true;

        //Приймає один тип, нічого ен повертає
        Consumer c1 = (t) -> System.out.println(t);

        //Приймає 2 типи, не повертає нічого
        BiConsumer<String, Boolean> bc = (a, b) -> System.out.println(b);

        //Приймає тип double, нічого ен повертає
        DoubleConsumer dc = (d) -> System.out.println();

        //Приймає один тип, повертає інший
        Function<Integer, String> f1 = (t) -> String.valueOf(t);
        Function<String, Boolean> f2 = (t) -> t.startsWith("");
        Function f3 = (t) -> "";

        //Приймає 2 типи, повертає третій
        BiFunction<Integer, String, Boolean> bi = (x, y) -> (x + Integer.parseInt(y)) > 3;

        //Нічого не приймає -повертає якийсь тип
        Supplier s1 = () -> 34;
        Supplier<String> s2 = () -> "Стрінга";

        //Нічого не приймає - повертає boolean
        BooleanSupplier bs = () -> true;
        //3)Можем викликати наш метод, а реалізацію не робити на льоту лямбдою, а заюзати вже існуючий метод з нашого касу
        method(Support::meth);
    }

    //3)Складніший кейс - маєм метод, який приймає якийсь з інтерфейсів, наприклад Predicate
    boolean method(Predicate<String> t) {
        String s = "asd";
        return t.test(s);
    }

}
//3)І маєм клас, який має метод, який підходить для реалізації метода інтерфейса Predicate, він примає якийсь тип, виконує дію і повертає boolean
class Support {
    public static boolean meth(String a) {
        return a.toUpperCase().equals("Значення");
    }
}



