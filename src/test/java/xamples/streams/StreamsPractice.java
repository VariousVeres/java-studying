package xamples.streams;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Stream API (Practice): Візьми List<WebElement> (або просто список стрінгів), відфільтруй порожні значення, приведи все до toLowerCase(),
 * збери в Set і знайди, чи є там хоч один елемент, що містить слово "error" - зроби сет без нього та відсортуй. Це класичний ланцюжок методів, який постійно потрібен у тестах.
 **/

public class StreamsPractice {

    Comparator<String> comparator = (o1, o2) -> o1.length() - o2.length();

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        list.add("Will Smith");
        list.add("Martin Lawrence");
        list.add("Robert De Niro");
        list.add("Al Pacino");
        list.add("Mark Wallberg");
        list.add("error");
        list.add("234");
        list.add("");

        Set<String> str = list.stream()
                .filter(Objects::nonNull)
                .filter(e -> !e.isEmpty())
                .sorted(comparator)
                .map(String::toLowerCase)
                .filter(e -> !e.contains("error"))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println(str);



    }
}
