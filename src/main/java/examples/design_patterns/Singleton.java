package examples.design_patterns;

import org.junit.Test;

class Example {
    private Example() {
    }

    private final static Example INSTANCE = new Example();

    public static Example initializeClass() {
        return INSTANCE;
    }

    public void sayHi() {
        System.out.println("Say Hi!");
    }

}

public class Singleton {
    @Test
    public void main() {
        Example.initializeClass().sayHi();
    }
}



