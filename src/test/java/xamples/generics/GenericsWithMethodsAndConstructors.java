package xamples.generics;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**Конструктор**/
class Team {
    String name;
    //Generic у методі / конструкторі допустимий ТІЛЬКИ тоді,
//коли він не визначає тип полів класу.

    public <H> Team(H symbol, String name) {
        this.name = name + symbol;
    }
}

public class GenericsWithMethodsAndConstructors {
    /**Метод**/
    //Generic у методі / конструкторі допустимий ТІЛЬКИ тоді,
//коли він не визначає тип полів класу.


    private <K, V> List<String> method(K id, V[] orders) {
        return Arrays.stream(orders).filter(o -> o.toString().contains("Loh"))
                .map(o -> id + ": " + o)
                .collect(Collectors.toList());
    }

    @Test
    public void test() {
        Team team = new Team(23, "Name");
        System.out.println(team.name);

        String[] arr = {"Павел", "Іван", "Христос", "Антоніо Бандерас", "Loh Петро", "А я не Loh", "Lohonator 2000"};
        method(2, arr);
        System.out.println(method(3, arr));




    }
}
