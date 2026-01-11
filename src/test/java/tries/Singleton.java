package tries;

import org.junit.Test;

class SingleSingle {

    String name = "Олег";
    int age;

    private final static SingleSingle single = new SingleSingle();

    private SingleSingle() {

    }

    public static SingleSingle makeClass() {
        return single;
    }

    public void sayHiMyNameIs() {
        System.out.println("Hi, my name is " + name);
    }

}


public class Singleton {
    @Test
    public void test() {
        SingleSingle singleSingle = SingleSingle.makeClass();
        SingleSingle vasyaKolya = SingleSingle.makeClass();
        singleSingle.sayHiMyNameIs();
        vasyaKolya.sayHiMyNameIs();
    }

}
