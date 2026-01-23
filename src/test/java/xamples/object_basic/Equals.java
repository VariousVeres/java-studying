package xamples.object_basic;

import org.junit.Test;

import java.util.Objects;

class Hat {

    private String type;

    void setType(String type) {
        this.type = type;
    }


    //Отак перевизначаєм equals щоб могти зрівнювати об'єкти Hat по полю type
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hat)) return false;
        Hat hat = (Hat) o;
        return Objects.equals(type, hat.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

}

class Sweater {
    private String type;

}

public class Equals {
    @Test
    public void test() {

        //Об'єкти без перевизначеного equals і хеш коду
        Sweater sweater1 = new Sweater();
        Sweater sweater2 = new Sweater();
        //false бо equals не перевизначений і рівняє по референсам
        System.out.println("Порівнюємо 2 однакові об'єкти без перевиз equals: " + sweater1.equals(sweater2));

        //Різні хеші
        System.out.println("Ну і хеші будуть різні в них також бо hashCode ми не чіпали теж: " + sweater1.hashCode() + " " + sweater2.hashCode() + "\n");
        //По замовчуванню в об'єкта тобто вони будуть порівнюватись по посиланню
        // public boolean equals(Object o) {
        //    return this == o;
        //}
        //Два різні обʼєкти НІКОЛИ не будуть рівні через equals() якщо ти не перевизначив equals()  і не задава по чому порівнювати сам


        Hat hat1 = new Hat();
        Hat hat2 = new Hat();

        //true бо equals перевизначений і рівняє логічно
        System.out.println("Порівнюємо 2 однакові об'єкти з перевизначеним equals: " + hat1.equals(hat2));
        System.out.println("Хеші будуть однакові в них бо hashCode також перевизначили: "+ hat1.hashCode() + " " + hat2.hashCode() + "\n");


    }
}
