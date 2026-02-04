package xamples.streams;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * CТРІМИ
 **/

public class StreamsBasics {
    @Test
    public void test() {
        /*Stream з ліста стрінгів*/
        System.out.println("------Починаються на О, в lowercase, foreach перших 3 символи------");
        List<String> list = Arrays.asList("OKI", "DOKI", "YO", "OPPOSUM", "MIST");
        list.stream().filter((a) -> a.startsWith("O"))
                .map((a) -> a.toLowerCase())
                .forEach((a) -> System.out.println(a.substring(0, 3)));  //Термінальна операція

        /*Стрім з різних типів*/
        System.out.println("------Стрім з різних типів--------");
        Stream.of(23, "STRING", true).forEach(o -> System.out.println(o));

        /*Спеціально для інтових стрімів, можем набити стрім самі методом rage*/
        System.out.println("------Інтовий стрім набитий автоматично через range--------");
        IntStream.range(8, 12)
                .forEach(System.out::println);

        /*Посортували*/
        System.out.println("------Посортований стрім--------");
        List<Integer> listInt = Arrays.asList(2, 5, 6, 87, 3, 9, 3, 6);
        listInt.stream().sorted().
                forEach(a -> System.out.println(a));

        /*Посортували*/
        System.out.println("------Посортований стрім через Comparator по довжині строки--------");
        List<String> fellowship = Arrays.asList("Gendalf", "Frodo", "Arven", "Golum", "Saruman", "Aragorn", "Legolas","Azoh");
        Comparator<String> comparator = (el1, el2) -> el1.length() - el2.length();

        List<String> fellowshipSorted = fellowship.stream().sorted(comparator).collect(Collectors.toList());
        System.out.println(fellowshipSorted);



        /*Виведе в консоль, якщо буде присутня тільки термінальна операція*/
        System.out.println("------Виведе в консоль, якщо буде присутня тільки термінальна операція--------");
        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .filter(s -> {
                    System.out.printf("Проміжна операція: " + s + " ");
                    return true;
                }).forEach(s -> System.out.println("Термінальна: " + s));


        /*Знаходим перий елемент стріма (термінальний метод)*/
        System.out.println("------Знаходим перий елемент стріма startsWith()--------");
        List<String> lsrt = new ArrayList<>();
        Collections.addAll(lsrt, "AF", "AB", "AG", "BA", "BF");
        Optional<String> first = lsrt.stream().findFirst();
        System.out.println("FIRST: " + first.orElseGet(() -> "DEFAULT"));

        /*Знаходим чи всі елементи починаються на А*/
        System.out.println("------Якщо всі елементи співпадуть умові то true--------");
        boolean b = lsrt.stream().allMatch(a -> a.startsWith("A")); //Якщо хоч щось співпаде
        System.out.println("СПІВПАЛО? - " + b);


//        /*Фільтрація filter*/
//        /*Відображення map*/
//        /*Сортування sorted*/
//        /*Перебір forEach*/
//        Stream.of(45, 7, 12, 49, 50, 23, 711).
//                filter(value -> value > 10).
//                map(operand -> ++operand)
//                .sorted()
//                .forEach(value -> System.out.println(value));
//
//
//        /*З арея в стрім, поформатували і назад і назад*/
//        int[] are = {-3, -3, -2, -1, 0, 0, 0, 1, 2, 3, -4, -5};
//
//        int[] results = Arrays.stream(are)
//                .distinct()
//                .sorted()
//                .map(operand -> 3 * operand)
//                .toArray();
//
//        for (int g : results) {
//            System.out.println(g);
//        }
    }

}
