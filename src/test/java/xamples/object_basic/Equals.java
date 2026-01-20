package xamples.object_basic;

import org.junit.Test;

import java.util.Objects;

class Hat {

    private String type;


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


        //False false - різні об'єкти з різними хешами та посиланнями на них
        Sweater sweater1 = new Sweater();
        Sweater sweater2 = new Sweater();
        System.out.println(sweater1.equals(sweater2));
        System.out.println(sweater1 == sweater2);
        //Різні хеші
        System.out.println(sweater1.hashCode() + " " + sweater2.hashCode() + "\n");
        //По замовчуванню в об'єкта тобто вони будуть порівнюватись по посиланню
        // public boolean equals(Object o) {
        //    return this == o;
        //}
        //Два різні обʼєкти НІКОЛИ не будуть рівні через equals() якщо ти не перевизначив equals()  і не задава по чому порівнювати сам


        Hat hat1 = new Hat();
        Hat hat2 = new Hat();

        System.out.println(hat1 == hat2);
        System.out.println(hat1.equals(hat2));


    }
}
