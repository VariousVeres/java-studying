package tasks.streams;

import org.testng.annotations.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Частина 1 — Тексти
 * flatMap → зробити один Stream<String>
 * прибрати null і blank
 * привести до toLowerCase
 * залишити тільки ті рядки, що містять "error"
 * прибрати дублі
 * зібрати в відсортований Set
 * ➡️ Результат 1:
 * Set<String> errors;
 **/

/** Частина 2 — Числа з тих самих текстів
 З тих же uiTexts:
 flatMap → Stream<String>
 прибрати null і blank
 витягнути числа з рядків
 ("Error 404" → 404, "User 3" → 3)
 👉 перехід Stream<String> → IntStream
 знайти:
 sum
 max
 average
 ➡️ Результат 2:
 long sum;
 int max;
 double average;
 **/

public class StreamTypeTransitionWithFlatMap {
    List<List<String>> uiTexts = List.of(
            List.of("Error 404", "Loading 10%", "User 1", "Angel error"),
            List.of("Error 500", "User 2", " ", "Error 500"),
            List.of("User 3", "Error 404")
    );

    @Test
    public void test() {
        TreeSet<String> treeSet1 = uiTexts.stream()
                .flatMap(e -> e.stream())
                .filter(e -> Objects.nonNull(e))
                .filter(e -> !e.isBlank())
                .map(e -> e.toLowerCase())
                .filter(e -> e.contains("error"))
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println(treeSet1);

        Supplier<IntStream> intStream = () ->uiTexts.stream()
                .flatMap(e -> e.stream())
                .filter(e -> e != null)
                .filter(e -> !e.isBlank())
                .map(e -> e.split(" "))
                .flatMap(e -> Arrays.stream(e))
                .filter(e -> e.matches("\\d+"))
                .mapToInt(Integer::parseInt);


        long sum = intStream.get().sum();
        int max = intStream.get().max().orElse(0);
       double avg = intStream.get().mapToDouble(e-> (double)e).average().orElse(0.0d);


    }
}
