package xamples.generics.neww;

import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.*;


class Game<T extends Temporal, E extends Map>  {
    T t;
    E e;

    Game(T type, E map)  {
        this.t=type;
        this.e=map;
    }
}

public class GenericBoundedClass {

    @Test
    public void test()  {
        Game<LocalDateTime, TreeMap> game = new Game<>(LocalDateTime.now(), new TreeMap<String, String>());
        System.out.println(game.e.size());

    }
}
