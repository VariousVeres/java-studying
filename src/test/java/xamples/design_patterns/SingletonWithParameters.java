package xamples.design_patterns;

import org.junit.Test;

class Single {
    private String str;

    private int i = 33;

    //Приватний конструктор щоб не можна було нізвідки викликати
    private Single(String s) {
        this.str = s;
    }

    //Статична змінна типу класу
    // (статична бо метод ініціалізації може бути тільки статичний бо втратиться зміст створення 1 об'єкту)
    private static Single instance;

    //Статичний метод котрий провіряє чи змінна вже ініціалізована і якщо ні то створює один об'єкт
    //Він синхронізований щоб одночасно кілька потоків не могли це зробити
    public synchronized static Single initializeClass(String s) {
        if (instance == null) {
            instance = new Single(s);
        }
        return instance;
    }

    public void sayHi() {
        System.out.println("Say Hi! - " + str);
    }

    //Тут ми змінюємо поле об'єкту, тобто змінюєм mutable стан і мусимо синхронізувати також
    public synchronized void increaseI() {
        System.out.println("INCREASED " + (++i));
    }

}

public class SingletonWithParameters {
    @Test
    public void main() {
        Single v = Single.initializeClass("Veres");
        //Тут вже не створить новий інстанс бо є вже створений
        Single p = Single.initializeClass("Petro");
        //Відповідно виводить дані єдиного об'єкту
        v.sayHi();
        p.sayHi();

    }
}



