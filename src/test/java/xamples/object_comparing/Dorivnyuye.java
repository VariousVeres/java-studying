package xamples.object_comparing;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

class Lock {
    Lock(String str) {

    }
}

public class Dorivnyuye {
    @Test
    public void test() {
        //Примітиви по значенню
        int i1 = 45;
        int i2 = 45;
        int i3 = 200;
        System.out.println("------ДОРІВНЮЄ ДЛЯ ПРИМІТИВІВ");
        System.out.println(i1 == i2);
        System.out.println((i1 == i3) + "\n");

        //Об'єкти по референсу
        Lock lock1 = new Lock("One");
        Lock lock2 = new Lock("One");
        System.out.println("------ДОРІВНЮЄ ДЛЯ ОБ'ЄКТІВ");
        System.out.println(lock1 == lock2);

        //Зробим reassign для другого поля на 1-ий об'єкт
        lock2 = lock1;
        System.out.println(lock1 == lock2);

        //Стрінги порівнює по референсу але в String pool буде реально 1 об'єкт
        String str1 = "Prometeus";
        String str2 = "Prometeus";
        System.out.println("------ДОРІВНЮЄ ДЛЯ ОДНАКОВИХ СТРІНГІВ");
        System.out.println(str1 == str2);

        //Через equals у однакових об'єктів буде рівність бо там equals ревизначений
        System.out.println("------EQUALS ДЛЯ ОДНАКОВИХ СТРІНГІВ");
        System.out.println(str1.equals(str2));

        System.out.println("------ДОРІВНЮЄ ДЛЯ ОДНАКОВИХ СТРІНГІВ АЛЕ ЧЕРЕЗ new (");
        //А от якщо створювати через new примусово то буде вже посилання на інший об'єкт
        String str3 = new String("Prometeus");
        System.out.println(str1 == str3);

        System.out.println("------ДОРІВНЮЄ ДЛЯ ОБ'ЄКТІВ LIST");
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        System.out.println(list1==list2);

    }
}
