package xamples.collections;

import org.junit.Test;

import java.util.*;

class Coffee {
    String type;

    Coffee(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coffee)) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(this.type, coffee.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

}

public class Sets {
    @Test
    public void test() {
        Set<String> countryHashSet = new HashSet<>();
        countryHashSet.add("Україна");
        countryHashSet.add("Франція");
        countryHashSet.add("Гондурас");
        countryHashSet.add("Кот-Д'Івуар");

        System.out.println(("Розмір HashSet = " + countryHashSet.size()));
        System.out.println(countryHashSet);
        //не додасть - поверне false
        boolean ukraineDuplicated = countryHashSet.add("Україна");
        System.out.println(ukraineDuplicated);
        System.out.println(countryHashSet);

        //Сет ітеруєтсья або фор ічом або ітератором або стрімом
        System.out.println("-----ІТЕРУЄМО СЕТ------");
        Iterator<String> it = countryHashSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }



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

        Set<Coffee> coffeeSet = new HashSet<>();
        Coffee c1 = new Coffee("Colombia");
        Coffee c2 = new Coffee("Colombia");
        Coffee c3 = new Coffee("Kolombia");

        //Не рівні бо порівнюються посилання
        System.out.println(c1 == c2);
        //Якщо перевизначити equals(Object o) то логічно рівні об'єкти будуть рівні

        System.out.println(c1.equals(c2));

        coffeeSet.add(c1);
        //Якщо перевизначити hashCode() то логічно рівні об'єкти будуть мати однаковий хеш
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

    }
}
