package xamples.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
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

        //Сортуємо
        Collections.sort(brandsList);

        //Маємо посортовано по величині рівенью
        for (Brands cat : brandsList) {
            System.out.println("Имя: " + cat.getName() + ", длина хвоста: " + cat.getRevenue());
        }


    }
}

