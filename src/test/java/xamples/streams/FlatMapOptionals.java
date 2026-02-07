package xamples.streams;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapOptionals {
    @Test
    public void test() {
        /** Arrays.asList() **/
        //Тут кине UnsupportedOperationException бо це гібридний ліст як ерей і ми не можемо додавати чи видаляти
        List<String> stringList = Arrays.asList("asd", "asd", "asdas");
//        stringList.add("sada");
//        stringList.remove("asd");

        /** List.of() **/
        //Тут кине UnsupportedOperationException бо це імутабельний ліст і ми не можемо нічого робити
        List<String> names = List.of("john", "alice");
//        names.set(0, "");


        //Виведе змінені в map елементи
        List<String> upper = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upper);


        /** Flat map **/
        // flatMap() розплющює вкладені структури в один потік - 2 ліста в 2 стріма і потім в 1 потік і робимо ліст
        List<List<String>> lists = List.of(List.of("a", "b"), List.of("c", "d"));

        List<String> flat1 = lists.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(flat1);

        // flatMap() розплющює вкладені структури в один потік - 2 стрінги в 2 масиви і потім в 1 потік і робимо ліст
        List<String> words = List.of("A B", "C D");

        List<String> flat2 = words.stream().flatMap(w -> Arrays.stream(w.split(" "))).toList();
        System.out.println(flat2);


    }
}
