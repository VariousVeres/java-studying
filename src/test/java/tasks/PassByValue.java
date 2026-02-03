package tasks;

import org.testng.annotations.Test;

class Box {
    int value;

    Box(int value) {
        this.value = value;
    }
}

class PassByValueTask {

    static void changePrimitive(int x) {
        x = 100;
    }

    static void changeObject(Box b) {
        b.value = 100;
    }

    static void reassignObject(Box b) {
        b = new Box(200);
    }

    static void tricky(Box b, int x) {
        b.value = x;
        x = 500;
        b = new Box(300);
        b.value = x;
    }


}

public class PassByValue {
    @Test
    public void test()  {
        int a = 10;
        Box box = new Box(10);

        PassByValueTask.changePrimitive(a);
        System.out.println("a = " + a);  //Тут буде

        PassByValueTask.changeObject(box);
        System.out.println("box.value = " + box.value);

        PassByValueTask.reassignObject(box);
        System.out.println("box.value = " + box.value);

        PassByValueTask.tricky(box, a);
        System.out.println("a = " + a);
        System.out.println("box.value = " + box.value);

    }

}
