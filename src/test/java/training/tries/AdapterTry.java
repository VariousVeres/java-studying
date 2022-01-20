package training.tries;
import org.junit.Test;

class Client {
    void catSays(Cat c) { c.meow();}
}
class Cat {
    String catName = "Tom";
    Cat() {};
    Cat(String str) {
        catName = str;
    }
    void meow() {
        System.out.println("Meow, Hi my name is " + catName);
    }
}
class Dog {
    String dogName;
    Dog(String str) {
        dogName = str;
    }
    void barf() {
        System.out.println("Barf, Hi my name is " + dogName);
    }
}
class DogToCatAdapter extends Cat {
    Dog dog;
    DogToCatAdapter(Dog d) {
        dog = d;
    }
    void meow() {
        dog.barf();
    }
}

public class AdapterTry {
    @Test
    public void main() {
        Client client = new Client();
        Cat cat = new Cat("Larry");
        client.catSays(cat);
        Dog dog = new Dog("Simon");
//        Так не вийде
//        client.method(dog);
        DogToCatAdapter dogToCat = new DogToCatAdapter(dog);
        client.catSays(dogToCat);
    }

}
