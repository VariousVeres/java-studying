package tries;

import org.junit.Test;

class Single {
    private int age;
    private String sex;

    private static Single instance = null;

    private Single(int age, String sex) {
        this.age = age;
        this.sex = sex;
    }

    public synchronized int getAge() {
        return age;
    }

    public synchronized String getSex() {
        return sex;
    }

    public synchronized void increaseAge() {
        age++;
    }

    public static synchronized Single getInstance(int age, String sex) {
        if (instance == null) {
            instance = new Single(age, sex);
            return instance;
        } else return instance;
    }
}

public class SingletonWithParameters {
    @Test
    public void test() {
        Single single = Single.getInstance(2, "male");
        Single single2 = Single.getInstance(3, "female");

        System.out.println(single.getSex());
        System.out.println(single2.getSex());


    }

}



