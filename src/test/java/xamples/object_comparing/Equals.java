package xamples.object_comparing;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Table {
    Table(String string) {
    }
}

class Mirror {
    String str;

    Mirror(String string) {
        this.str = string;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Mirror)) return false;
        return Objects.equals(this.str, ((Mirror) obj).str);
    }

}

public class Equals {
    @Test
    public void test() {
        //Якщо не перевизначити equals то об'єкти буде порівнювати по референсу
        Table coffeeTable1 = new Table("Coffee");
        Table coffeeTable2 = new Table("Coffee");
        System.out.println("--------ПОРІВНЮЄМО ОДНАКОВІ ОБ'ЄКТИ БЕЗ ПЕРЕВИЗНАЧЕННЯ EQUALS");
        System.out.println(coffeeTable1.equals(coffeeTable2));

        //Якщо перевизначити equals то об'єкти буде порівнювати по логічному значенню
        Mirror mirror1 = new Mirror("Bathroom");
        Mirror mirror2 = new Mirror("Bathroom");
        System.out.println("--------ПОРІВНЮЄМО ОДНАКОВІ ОБ'ЄКТИ З ПЕРЕВИЗНАЧЕННЯМ EQUALS");
        System.out.println(mirror1.equals(mirror2));
        //Різні об'єкти будуть нерівні
        System.out.println("--------ПОРІВНЮЄМО РІЗНІ ОБ'ЄКТИ З ПЕРЕВИЗНАЧЕННЯМ EQUALS");
        Mirror pocketMirror = new Mirror("Pocket mirror");
        System.out.println(mirror1.equals(pocketMirror));

        //Порівнюється як всі об'єкти бо в Стрінгів первизначений equals
        String s1 = "Lara Croft";
        String s2 = "Lara Croft";
        System.out.println("--------ПОРІВНЮЄМО ОДНАКОВІ STRING ОБ'ЄКТИ");
        System.out.println(s1.equals(s2));

        String shangTsung = "Shang Tsung";
        System.out.println("--------ПОРІВНЮЄМО РІЗНІ STRING ОБ'ЄКТИ");
        System.out.println(s1.equals(shangTsung));
        System.out.println("--------ПОРІВНЮЄМО ОДНАКОВІ STRING ОБ'ЄКТИ СТВОРЕНІ ЧЕРЕЗ new");
        String shangTsunG = new String("Shang Tsung");
        System.out.println(shangTsung.equals(shangTsunG));


        List<String> list1 = new ArrayList<>();
        list1.add("One");
        list1.add("Two");
        List<String> list2 = new ArrayList<>();
        list2.add("One");
        list2.add("Two");
        System.out.println("--------ПОРІВНЮЄМО ОДНАКОВІ LIST ОБ'ЄКТИ");
        System.out.println(list1.equals(list2));

        System.out.println("--------ПОРІВНЮЄМО LIST ОБ'ЄКТИ З ОДНАКОВИМИ ЕЛЕМЕНТАМИ АЛЕ РІЗНИМ ПОРЯДКОМ");
        List<String> list3 = new ArrayList<>();
        list3.add("Two");
        list3.add("One");
        System.out.println(list1.equals(list3));

        list2.add("Three");
        System.out.println("--------ПОРІВНЮЄМО НЕОДНАКОВІ LIST");
        System.out.println(list1.equals(list2));


    }
}
