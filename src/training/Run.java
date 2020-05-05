package training;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Stream.*;

interface Ren {
abstract void print();
}


public class Run {

    public void test1() {
        /*Stream з ліста стрінгів*/
//        List<String> list = Arrays.asList("OKI", "DOKI", "YO", "OPPOSUM", "MIST");
//        list.stream().filter((a) -> a.startsWith("O"))
//                .map((a) -> a.toLowerCase())
//                .forEach((a) -> System.out.println(a.substring(0, 3)));  //Термінальна операція
//
//
//        /*Стрім з різних типів*/
//        Stream.of(23, "STRING", true).forEach(o -> System.out.println(o));
//
//
//        /*Спеціально для інтових стрімів, можем набити стрім самі методом rage*/
//        IntStream.range(8, 12)
//                .forEach(System.out::println);
//        /*Посортували*/
//        List<Integer> listInt = Arrays.asList(2, 5, 6, 87, 3, 9, 3, 6);
//        listInt.stream().sorted().
//                forEach(a -> System.out.println(a));


//        /*Виведе в консоль, якщо буде присутня тільки термінальна операція*/
//        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
//                .filter(s -> {
//                    System.out.println("Проміжна операція: " + s);
//                    return true;
//                }).forEach(s -> System.out.println("Термінальна: " + s));


//        /*Знаходим перий елемент стріма (термінальний метод)*/
//        List<String> lsrt = new ArrayList<>();
//        Collections.addAll(lsrt, "AF", "AB", "AG", "BA", "BF"); //Тут трохи незрозуміло
//        Optional<String> first = lsrt.stream().findFirst();
//        System.out.println(first.toString());
//        boolean b = lsrt.stream().allMatch(a -> a.startsWith("A")); //Якщо хоч щось співпаде
//        System.out.println(b);


//        /*Фільтрація filter*/
//        /*Відображення map*/
//        /*Сортування sorted*/
//        /*Перебір forEach*/
//        Stream.of(45, 7, 12, 49, 50, 23, 711).
//                filter(value -> value > 10).
//                map(operand -> operand++)
//                .sorted()
//                .forEach(value -> System.out.println(value));


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



    static void print() {
        System.out.println("asd");
    }




}
