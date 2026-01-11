package xamples.interfaces;

import org.junit.Test;

interface ParentInterface {

    void doNothing();

    void makeMoney();

    String writePoem();

}

class ChildClass implements ParentInterface {
    private float cash = 23.45f;
    private String poem;

    @Override
    public void doNothing() {
        System.out.println("Doing nothing");
    }

    @Override
    public void makeMoney() {
        System.out.println("Making money: " + cash + "$");
    }

    @Override
    public String writePoem() {
        poem = "When i walk through the valley of shadow of death...";
        System.out.println(poem);
        return poem;
    }
    //Метод тільки для класу
    public void onlyChildMethod()  {
        System.out.println("Only child!");
    }
}

public class Interfaces {

    @Test
    public void test()  {
        ChildClass childClass = new ChildClass();
        //Метод з контракту інтерфейс реалізований в чайлд класі
        childClass.makeMoney();
        //А це вже метод тільки з чайлд класу, якщо типу буде інтерфейс він не буде доступний
        childClass.onlyChildMethod();

        ParentInterface parentInterface = new ChildClass();
//        parentInterface.onlyChildMethod(); - отак не канає

    }

}
