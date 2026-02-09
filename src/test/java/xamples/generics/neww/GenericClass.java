package xamples.generics.neww;

import org.testng.annotations.Test;

class Baby {
    public void say() {
        System.out.println("Baby");
    }
}  class Toddler{}

//Оголошуємо тип <T> для класу щоб був контракт між ним та колером
// про однаковий тип з яким ми працюємо
class Box<T>  {
    private T t;
    Box(T t) {
        this.t=t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
    public void say() {
        System.out.println("Box "+ t);
    }

}

public class GenericClass {
    @Test
    public void test() {
        //А тут вже можем кліпати класи з потрібним нам типом знаючи що будь який заканає
        Box<String> b1 = new Box<>("String");
        b1.say();
        Box<Boolean> b2 = new Box<>(true);
        b2.say();

        //Якщо отак будем створювати без типу то це втрачається прив'язка до типу
        // і буде просто Object і потім кастити треба
        Box rawBox = new Box<>("Raw");
       String s = (String) rawBox.getT();
       //Отак без типу ми засетати даже можем шо хоч але потім отримуємо ClassCastException
       rawBox.setT(123);
//       String str = (String) rawBox.getT();

        //Отак не заканає вже точно через різні типи
//        Box<Long> b3 = new Box<>(new Integer(3));

        //Навіть якщо ти це клас об'єкту то все працюватиме
        Box<Baby> babyBox = new Box<>(new Baby());
        babyBox.getT().say();

    }
}
