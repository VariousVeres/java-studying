package xamples.java_8;

import org.junit.Test;

/**
 * ЛЯМБДА ЯК ПАРАМЕТР МЕТОДУ
 **/

//Інтерфейс з методом з трьома парамерами, який вертає інт//
interface Inhisface {
    int method(int a, int b, String str);
}

public class Lambdas2 {
    //Метод, який приймає реалізацію інтерфейсу, як параметр//
    //Ми тут ще не знаєм, що саме буде відбуватись в методі
    public static void methodTakesLambda(Inhisface ihf) {
        ihf.method(25, 118, "Кількість хокеїстів");
    }

    @Test
    public void print1() {
        //Створюєм лямбду, яка реалізовує інтерфейс і задаєм як параметр в виклиці методу//
        Inhisface ihf = (int a, int b, String str) -> {
            System.out.println(str + " - " + b / a + 324);
            return 3;
        };
        Lambdas2.methodTakesLambda(ihf);
        //Або реальізовуєм інтерфейс на льоту пр ивиклиці методу//
        Lambdas2.methodTakesLambda((int a, int b, String str) -> {
            System.out.println(str + " - " + b / a);
            return 0;
        });
    }
}

/**
 * Складніший приклад
 **/

//Інтерфейс з методом, який приймає один параметр int, щось з ним робить і вертає boolean//
interface Operation {
    boolean method(int a);
}

class Lambda22 {
    //Метод приймає масив і екземпляр інтерфейсу і рахує суму елементів масиву, які відповідають умові метода
    public static int sumOfPairInArray(int[] arr, Operation o) {
        int result = 0;
        for (int elem : arr) {
            /**Тут ми замість умови використовуєм результат виконання методу з інтерфейсу**/
            if (o.method(elem)) {
                result += elem;
            }
        }
        System.out.println(result);
        return result;

    }

    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    @Test
    public void print2() {

        /**А вже тут ми на льоту реалізовуєм цей метод, і можем кожен раз змінювати умову**/
        Lambda22.sumOfPairInArray(arr, (a) -> a % 2 == 0);
        Lambda22.sumOfPairInArray(arr, (a) -> a % 2 == 1);
        Lambda22.sumOfPairInArray(arr, (a) -> a > 4);
    }

}
