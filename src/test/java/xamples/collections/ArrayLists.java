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
        List<String> arrayList = new ArrayList<>(3);
        arrayList.add("Вася");
        arrayList.add("Коля");
        arrayList.add("Петя");
        arrayList.add("Бастард"); //Resize масиву

        System.out.println(arrayList.get(2));
        //Замінюємо елемент по індексу
        arrayList.set(1, "Заміна");

        System.out.println(arrayList.get(1));
        System.out.println(arrayList);
        //Колі вже немає
        System.out.println(arrayList.contains("Коля"));

        //перетворюєм в масив
        Object[] stringArray = arrayList.toArray();
        System.out.println(Arrays.toString(stringArray));

        //Видаляємо по елементу
        arrayList.remove("Бастард");
        //Бастарда вже немає
        System.out.println(arrayList);

        //Очищаємо ліст
        arrayList.clear();
        System.out.println(arrayList);


        //Застосовуємо ліст ітератор для перебору та зміни
        List<String> cats = new ArrayList<>();
        cats.add("Васька");
        cats.add("Барсік");
        cats.add("Мурзік");
        cats.add("Пірат");
        cats.add("Чіндосик");

        ListIterator<String> listIterator = cats.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().equals("Пірат")) {
                listIterator.remove();
            }
        }

        System.out.println(cats);


    }
}
