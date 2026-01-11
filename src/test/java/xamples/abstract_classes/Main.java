package xamples.abstract_classes;

import org.junit.Test;

public class Main {

    @Test
    public void test()  {
        ChildOfAbstract childOfAbstract = new ChildOfAbstract("Вася", 23);
        //Абстрактний метод з перента реалізований в чайлді
        childOfAbstract.sayAge();
        //Зивчайний метод з перента унаслідуваний чайлдом
        childOfAbstract.sayName();


        //Можна на льоту створювати анонімний клас без наслідування і реалізовувати метод зразу (схожеч через лямбди)
        AbstractClass abstractClass = new AbstractClass("Коля", 18) {
            @Override
            public void sayAge() {

            }
        };
    }
}
