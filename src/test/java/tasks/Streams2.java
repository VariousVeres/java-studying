package tasks;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

/**Завдання 1 — Валідація текстів елементів (ТОП для UI-тестів)

 Є: List<String> (умовно — getText() з елементів)
 Умови:
 прибрати null і порожні / blank
 привести до toLowerCase
 прибрати всі значення, що містять "loading"
 прибрати дублі
 відсортувати за алфавітом
 повернути Set
 перевірити, що немає жодного значення, яке містить "error"
 Очікуваний результат:
 відсортований Set<String>
 boolean hasError = false**/

public class Streams2 {
    @Test
    public void test(){
        List<String> list = new ArrayList<>() {};
        list.add("Amenra");
        list.add("Caliban");
        list.add("Electric wizard");
        list.add("Gojira");
        list.add("Gojira");
        list.add("A place to bury strangers");
        list.add("");
        list.add(" ");
        list.add(null);
        list.add("Loaded gun");
        list.add("Band name is loading...");
        list.add("error");

        boolean hasError = list.stream()
                .filter(Objects::nonNull)
                .map(String::toLowerCase)
                .anyMatch(s -> s.contains("error"));

        Set<String> set = list.stream().filter(Objects::nonNull)
                .filter(e->!e.isEmpty() && !e.isBlank())
                .filter(e->!e.contains("loading"))
                .filter(e->!e.contains("error"))
                .collect(Collectors.toCollection(TreeSet::new));


        System.out.println(set);
        System.out.println(hasError);


    }
}
