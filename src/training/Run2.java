package training;


import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleConsumer;
import java.util.function.Predicate;

/**
 * ЗАСТОСУВАННЯ Ф-ЦІОНАЛЬНИХ ІНТЕРФЕЙСІВ
 **/

public class Run2 {
    @Test
    public void method() {
    Predicate<Integer> p = (a) -> (a % 2) == 0;

    DoubleConsumer dc = (a) -> System.out.println(a + " ");
        dc.accept(0.25);
    BiConsumer bc = (a, b) -> System.out.println((int) a + (int) b);
        bc.accept(23,45);
    BooleanSupplier bs = () -> {
        System.out.println(false);
        return false;
    };
        bs.getAsBoolean();

        Pituh.summOfArrayElements(new int[]

    {
        3, 4, 5, 6, 34
    },(a)->(Integer)a %2==0);
}

}

class Pituh {
    public static int summOfArrayElements(int[] arr, Predicate p) {
        int result = 0;
        for (int elem : arr) {
            if (p.test(elem)) {
                result += elem;
            }
        }
        System.out.println(result);
        return result;
    }

}





