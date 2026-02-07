package tasks.streams;

import org.testng.annotations.Test;

import java.util.*;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/*Треба:
прибрати null
прибрати blank ("", " ")
залишити тільки числа
привести до int
знайти:
sum
max
average*/

public class Streams {
    @Test
    public void test() {
        List<String> values = new ArrayList<>();
        values.add("10");
        values.add("  ");
        values.add("25");
        values.add("error");
        values.add("5");
        values.add(null);
        values.add("30");
        List<String> normalized = values.stream()
                .filter(Objects::nonNull)
                .filter(e -> !e.isBlank())
                .toList();

        System.out.println(normalized);

        List<String> stringList = normalized.stream().filter(e -> {
                    try {
                        Integer.parseInt(e);
                        return true;
                    } catch (Exception ex) {
                        return false;
                    }
                })
                .toList();


        long sum = stringList.stream()
                .mapToInt(Integer::parseInt)
                .sum();

        int max = stringList.stream()
                .mapToInt(Integer::parseInt)
                .max()
                .orElse(0);

        double average = stringList.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);


    }
}
