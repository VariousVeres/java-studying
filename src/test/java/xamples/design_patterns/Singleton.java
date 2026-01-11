package xamples.design_patterns;


import org.junit.Test;

class Singel {

    private String name;
    //Приватний конструктор щоб не можна було створити об'єкт тільки в цьому класі
    private Singel() {
    }

    //Фіналізований статичний референс на об'єкт який ми створюєм одразу в класі (статичний бо метод який буде ініціалізувати також статичний
    // бо по-іншому не може бути коли конструтор приватний і ми не можемо створити о'єкт просто через new
    private static final Singel singel = new Singel();


    //Метод який буде повертати один і той самий об'єкт Сінглтон, синхронізовувати не потрібно бо 1 раз об'єкт вже створився при ініціалізації класу
    static Singel getInstance() {
        return singel;
    }

    //Синхронізовуємо бо з різних потоків може перетирати значення через race condition
    public synchronized void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


public class Singleton {

    @Test
    public void test() {
        Singel singel = Singel.getInstance();
        Singel singel2 = Singel.getInstance();

        //Провіряєм чи це той самий об'єкт
        System.out.println("Чи це тйо самий об'єкт - " + (singel2 == singel));
        //Зрівнюєм хеші
        System.out.println(singel.hashCode());
        System.out.println(singel2.hashCode());



    }


}
