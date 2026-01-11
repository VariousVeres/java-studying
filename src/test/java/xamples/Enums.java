package xamples;

import org.junit.Test;

enum Felines {
    TIGER("Тигр"),
    COUGAR("Ягуар"),
    LYNX("Рись"),
    LION("Лев"),
    LEOPARD("Леопард"),
    CAT("Кіцік");

    Felines(String name) {
        this.felineName = name;
    }

    String felineName;

    //Перевизначаємо toString щоб виводити значення в дужках
    public String toLocalizedString() {
        return felineName;
    }
}

public class Enums {

    @Test
    public void test() {
        System.out.println(Felines.CAT);
        System.out.println(Felines.CAT.toLocalizedString());

        //Масив зі всіма значеннями енамки
        Felines[] array = Felines.values();
        System.out.println("3ій елемент з масиву кошачих - " + array[2]);

        //Вичисляємо значення енамки зі стрінги
        Felines lynx = Felines.valueOf("LYNX");
        System.out.println(lynx.toLocalizedString());

        //Позиція елемента в енамці
        int ordinal = Felines.LION.ordinal();
        System.out.println(Felines.LION.toLocalizedString() + " знаходиться в енамці на " + (ordinal + 1) + " позиції");
    }
}
