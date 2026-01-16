package xamples.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Імплементим інтерфейс Comparable

class Brands implements Comparable<Brands> {
    private double revenue;
    private String name;

    public Brands(double revenue, String name) {
        this.revenue = revenue;
        this.name = name;
    }

    public double getRevenue() {
        return revenue;
    }

    public String getName() {
        return name;
    }


    //В ньому задаємо правила по чому будем порівнювати - якщо більше плюсове, меніше мінусове, рівне то нуль
    @Override
    public int compareTo(Brands o) {

        double dif = revenue - o.revenue;

        if (dif != 0) {
            return (int) dif;
        }
        return 0;
    }


}

public class Comparabels {
    @Test
    public void test() {
        Brands apple = new Brands(23.4, "Apple");
        Brands microsoft = new Brands(13.4, "Microsoft");
        Brands nVidia = new Brands(18.1, "Nvidia");
        Brands openAI = new Brands(6.5, "Open AI");
        List<Brands> brandsList = new ArrayList<>();
        brandsList.add(apple);
        brandsList.add(microsoft);
        brandsList.add(nVidia);
        brandsList.add(openAI);

        //Сортуємо (В випадку Comparable це природнє сортування, Java сама знає як сортувати через перевизначений метод)
        Collections.sort(brandsList);

        //Маємо посортовано по величині рівенью від меншого до більшого
        for (Brands cat : brandsList) {
            System.out.println("Имя: " + cat.getName() + ", длина хвоста: " + cat.getRevenue());
        }


        //Робимо окремий компаратор для сортування де вже будем сортувати від більшого до меншого наприклад
        Comparator<Brands> comparator1 = new Comparator<>() {
            @Override
            public int compare(Brands o1, Brands o2) {
                return (int) (o2.getRevenue() - o1.getRevenue());
            }
        };

        //Сортуємо за допомогою компаратора
        Collections.sort(brandsList, comparator1);
        System.out.println("\n");
        //Маємо посортовано по величині рівенью від більшого до меншого
        for (Brands cat : brandsList) {
            System.out.println("Имя: " + cat.getName() + ", длина хвоста: " + cat.getRevenue());
        }
        //Реалізуємо компаратор через інтерфейс і по довжині імені сортуємо
        Comparator<Brands> comparator2 = (o1, o2) -> {
            int i = o1.getName().length() - o2.getName().length();
            return i;
        };


        Collections.sort(brandsList, comparator2);

        System.out.println("\n");

        for (Brands cat : brandsList) {
            System.out.println("Ім'я: " + cat.getName() + ", Revenue: " + cat.getRevenue());
        }


    }
}

