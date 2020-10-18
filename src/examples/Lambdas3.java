package examples;

import org.junit.Test;

/**
 * Інтерфейс з методом, який приймає один параметр int, щось з ним робить і вертає boolean
 **/
interface Operation {
    boolean method(int a);
}

public class Lambdas3 {

    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};


    //Метод приймає масив і екземпляр інтерфейсу і рахує суму елементів масиву, які відповідають умові метода
    public static int sumOfPairInArray(int[] arr, Operation o) {
        int result = 0;
        for (int elem : arr) {
            /**Тут ми замість умови використовуєм результат виконання методу з інтерфейсу**/
            if (o.method(elem)) {
                result += elem;
            }
        }
        return result;
    }

    /**
     * Реалізовуєм інтерфейс так, що метод повертатиме true, коли параметр буде не 3, 5 або 8
     **/
    Operation op = (int a) -> {
        if (a == 3 || a == 5 || a == 8) {
            return false;
        } else return true;
    };

    @Test
    public void test() {
        /**А вже тут ми на льоту реалізовуєм цей метод, і можем кожен раз змінювати умову**/
        int sum1 = Lambdas3.sumOfPairInArray(arr, (int a) -> a % 2 == 0);
        int sum2 = Lambdas3.sumOfPairInArray(arr, (int a) -> a % 2 == 1);
        int sum3 = Lambdas3.sumOfPairInArray(arr, op);

        System.out.println("Сумма парних елементів масиву - " + sum1);
        System.out.println("Сумма парних елементів масиву - " + sum2);
        System.out.println("Сумма всіх елементів масиву крім 3,5,8 - " + sum3);

    }
}
