package xamples.abstract_classes;

import org.junit.Test;

abstract class AbstractParent {
    private String name;

    private int age;

    //Є конструктор для наслідування
    public AbstractParent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Є логіка яка реалізована в класі
    public void sayName() {
        System.out.println("My name is " + name);
    }

    //Є метод, який по контракту має бути реалізований при наслідуванні
    public abstract void sayAge();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class ChildOfAbstract extends AbstractParent {
    public ChildOfAbstract(String name, int age) {
        super(name, age);
    }

    //Реалізація анонімного методу (Без цього не створиться клас)
    @Override
    public void sayAge() {
        System.out.println("My age is " + getAge());
    }
}

public class AbstractClass {

    @Test
    public void test() {
        ChildOfAbstract childOfAbstract = new ChildOfAbstract("Вася", 23);
        //Абстрактний метод з перента реалізований в чайлді
        childOfAbstract.sayAge();
        // Зивчайний метод з перента унаслідуваний чайлдом
        childOfAbstract.sayName();
        //Можна на льоту створювати анонімний клас без наслідування і реалізовувати метод зразу (схожеч через лямбди)
        AbstractParent abstractClass = new AbstractParent("Коля", 18) {
            @Override
            public void sayAge() {
            }
        };
    }


}
