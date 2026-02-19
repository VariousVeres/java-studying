package xamples.generics.neww;

import org.testng.annotations.Test;

class Animal {

}

class Dog extends Animal {
}

class Cat extends Animal {
}

class Car {
}

public class GenericMethod{
    //Метод який оперує типом <Т> без bounds та повертає саме той тип T який ми передаєм в нього

    <T> T identity(T value) {

        return value;
    }



    @Test
    public void test() {
        Dog dog = identity(new Dog());
        Cat cat = identity(new Cat());
        String s = identity("hello");
        Car car = identity(new Car());


//  ❌ Це НЕ має працювати:
//        int x = identity("hello");

    }
}





