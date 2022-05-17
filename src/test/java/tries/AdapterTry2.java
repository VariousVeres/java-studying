package tries;

import org.junit.Test;

class Program {
    public void takeNeededTypeAndDoSmthing(NeededType type) {
        type.doSmthing();
    }
}

interface NeededType {
    void doSmthing();
}

class NeededType1 implements NeededType {
    public void doSmthing() {
        System.out.println("I am doin smthing like needed type 1");
    }
}

class NeededType2 implements NeededType {
    public void doSmthing() {
        System.out.println("I am doin smthing like needed type 2");
    }
}

class NotNeededType {
    public void notDoSomthing() {
        System.out.println("I am not doing smthing cause i am not needed type");
    }
}

class AdapterForNotNeededToNeeded implements NeededType {
    NotNeededType notNeeded;

    AdapterForNotNeededToNeeded(NotNeededType notNeddetType) {
        this.notNeeded = notNeddetType;
    }

    @Override
    public void doSmthing() {
        notNeeded.notDoSomthing();
    }
}

public class AdapterTry2 {
    @Test
    public void main() {
        Program p = new Program();
        NotNeededType notNeeded = new NotNeededType();
        AdapterForNotNeededToNeeded adapterForNotNeeded = new AdapterForNotNeededToNeeded(notNeeded);
        p.takeNeededTypeAndDoSmthing(adapterForNotNeeded);
    }
}
