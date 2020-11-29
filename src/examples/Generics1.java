package examples;

import java.util.*;

import org.junit.Test;

/**
 * ДЖЕНЕРІКИ
 **/

//1)Наприклад є клас в якому метод приймає якийсь тип, але ми не знаєм який це буде тип насправді
class Generic1<T> {
    void method(T t) {
        System.out.println(t);
    }
}

//2) Можна оголошувати клас без дженерік типу а просто в методі вказувати його, але тоді такий тип буде локальним тільки для цього методу
class Generic2 {
    // Змінну такого типу ми вже не оголосим
    //private T variable;
    //В лапках тип, який використовуєм в методі, без лапок - який повертаєм
    <T> T method(T t) {
        System.out.println(t);
        return t;
    }
}

//3)Або ж клас в якому метод приймає кілька типів, але ми не знаєм який це буде тип насправді
class Generic3<T, R> {
    private T t;
    private R r;

    Generic3(T t, R r) {
        this.r = r;
        this.t = t;
    }

    T getT() {
        System.out.println(t);
        return t;
    }

    R getR() {
        System.out.println(r);
        return r;
    }
}

// 4)Можна обмежувати дженерік тип, наприклад тут можна буде передати всі типи, які наслідують Collection
class Generic4<T extends Collection> {
    private T list;
    public void listMethod(T t) {
        list = t;
        System.out.println(list);
    }
}
// 5)Дженеріки в інтерфейсі, схоже як в ф-ціональних інтерфейсах
interface Generic5<T, S> {
    T method(S s);
}

public class Generics1 {
    //5) Приклад з сортуванням масиву, в параметрі інтерфейс, який поверне булін, якщо умова з Integer виконається
    private void method(Generic5<Boolean, Integer> interf, int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int elem : arr) {
            if (interf.method(elem)) {
                list.add(elem);
            }
        }
        System.out.println(list);
    }
    @Test
    public void main() {
        // 1)Створюєм інстанс класу, при цьому визначаємо тип, який буде юзатись
        Generic1<Integer> gem1 = new Generic1<>();
        gem1.method(34);
        Generic1<String> gem2 = new Generic1<>();
        gem2.method("Стрінга");

        //2) Якщо буде клас без типу можна при створенні інстансу не приводити тип
        Generic2 gen2 = new Generic2();
        //І буде все рівно той тип повернутий, який нам потрібно
        System.out.println(gen2.method("777").getClass());

        // 3)Створюєм інстанс класу, при цьому визначаємо обидва типи, які буде юзатись
        Generic3<String, Integer> gem3 = new Generic3<>("Сінгапур", 23);
        gem3.getR();
        gem3.getT();

        //Можем навіть ліст передати
        Generic3<List<String>, Integer> gem4 = new Generic3<>(Arrays.asList("ELem1", "Elem2", "Elem3"), 17);
        gem4.getR();
        gem4.getT();

        //Навіть можем передати інстанс типу нашого першого класу Generic1<T>,
        Generic3<Generic1<String>, Integer> gem5 = new Generic3<>(new Generic1<>(), 23);
        gem5.getR();
        gem5.getT().method("Передали типу класу з дженеріком, як параметр іншого класу з дженерік типами");

        //4) Тоді ми можем передати тільки тип який наслідує Collection
        Generic4<List<String>> gem6 = new Generic4<>();
        gem6.listMethod(new ArrayList<>());
        Generic4 gem7 = new Generic4<>();
        //Мапу не передаш вже
        //gem7.listMethod(new HashMap<String,String>());
        //А сет можна, бо він наслідує Collection
        gem7.listMethod(new HashSet<String>());

        //5) А в виклмці ми на льоту реалізовуєм цей інтерфейс і підставляєм будь- яку умову
        method((s) -> s > 4, new int[]{3, 12, 46, 89, 4, 5, 6, 98, 4, 2, 23, 45});
        method((s) -> s % 2 == 0, new int[]{3, 12, 46, 89, 4, 5, 6, 98, 4, 2, 23, 45});
        method((s) -> s % 2 == 1, new int[]{3, 12, 46, 89, 4, 5, 6, 98, 4, 2, 23, 45});
    }
}


