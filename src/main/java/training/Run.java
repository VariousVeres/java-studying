package training;

interface One {
    void say();
}

class Two implements One {
    @Override
    public void say() {
        System.out.println("TWO");
    }
}

class Three implements One {
    @Override
    public void say() {
        System.out.println("THREE");
    }
}

public class Run {
    public static One method(int i) {
        if (i > 2) {
            return new Two();
        } else return new Three();
    }

    public static void main(String[] args) {
        One three = Run.method(3);
        One two = Run.method(2);
        two.say();
        three.say();
        One two2 = new Two();
        One three2 = new Three();
        two2.say();
        three2.say();

    }

}
