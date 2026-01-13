package xamples.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ArrayLists {
    @Test
    public void test() {
        //Тип ліст бо нам вистачає дефолтних методів ліста
        List<String> arrayList = new ArrayList<String>(3);
        arrayList.add("Вася");
        arrayList.add("Коля");
        arrayList.add("Петя");
        arrayList.add("Бастард"); //Resize масиву
        System.out.println(arrayList);

        //Можна додавати по індексу
        arrayList.add(1, "Мухамед");
        System.out.println(arrayList);

        //Замінюємо елемент по індексу
        arrayList.set(1, "Заміна");

        System.out.println(arrayList.get(1));
        System.out.println(arrayList);
        //Мухамеда вже немає
        System.out.println(arrayList.contains("Коля"));

        //перетворюєм в масив
        Object[] stringArray = arrayList.toArray();
        System.out.println(Arrays.toString(stringArray));

        //Видаляємо по елементу
        arrayList.remove("Бастард");
        //Бастарда вже немає
        System.out.println(arrayList);

        //Видаляємо по індексу
        arrayList.remove(0);
        //Васі вже немає
        System.out.println(arrayList);

        //Очищаємо ліст
        arrayList.clear();
        System.out.println(arrayList);


        //Застосовуємо ліст ітератор для перебору та ставки Бонітика після Пірата
        List<String> cats = new ArrayList<String>();
        cats.add("Васька");
        cats.add("Барсік");
        cats.add("Мурзік");
        cats.add("Пірат");
        cats.add("Чіндосик");


        ListIterator<String> listIterator = cats.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().equals("Пірат")) {
                listIterator.add("Бонітик");
            }
        }

        System.out.println(cats);


    }
}
