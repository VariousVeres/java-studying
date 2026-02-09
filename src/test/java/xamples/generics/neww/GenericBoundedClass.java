package xamples.generics.neww;

import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;

class Game<T extends Temporal, E extends RuntimeException>  {
    T t;
    E e;

    Game(T type, E exception)  {
        this.t=type;
        this.e=exception;
    }
}

public class GenericBoundedClass {

    @Test
    public void test()  {
        Game<LocalDateTime, NullPointerException> game = new Game<>(LocalDateTime.now(), new NullPointerException());
        throw game.e;
    }
}
