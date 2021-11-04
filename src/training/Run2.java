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
        System.out.println("New branch");
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





