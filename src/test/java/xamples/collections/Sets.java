package xamples.collections;

import org.junit.Test;

import java.util.*;

public class Sets {
    @Test
    public void test() {
        Set<String> countryHashSet = new HashSet<>();
        countryHashSet.add("Україна");
        countryHashSet.add("Франція");
        countryHashSet.add("Гондурас");
        countryHashSet.add("Кот-Д'Івуар"); // любимая страна всех котов

        System.out.println(("Розмір HashSet = " + countryHashSet.size()));
        System.out.println(countryHashSet);
        //не додасть - поверне false
        boolean ukraineDuplicated = countryHashSet.add("Україна");
        System.out.println(ukraineDuplicated);
        System.out.println(countryHashSet);


        Random random = new Random(30);
        Set<Integer> numberSet = new HashSet<>();
        //Ітеруємо 1000 раз а додали тільки 10 унікальних
        for (int i = 0; i < 1000; i++) {
            numberSet.add(random.nextInt(10));
        }
        System.out.println(numberSet);

        //В TreeSet буде сортувати
        TreeSet<String> carModelsSet = new TreeSet<>();
        carModelsSet.add("BMW");
        carModelsSet.add("Audi");
        carModelsSet.add("Opel");
        carModelsSet.add("Mazda");
        carModelsSet.add("Tesla");
        System.out.println(carModelsSet);

    }
}
