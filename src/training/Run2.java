package training;


import org.junit.Test;

import java.util.function.Predicate;

/**
 * ЗАСТОСУВАННЯ Ф-ЦІОНАЛЬНИХ ІНТЕРФЕЙСІВ
 **/

public class Run2 {
    @Test
    public void method() {
        System.out.println("New branch");
        Pituh p = new Pituh();

        p.summOfArrayElements(new int[]{3, 4, 5, 87, 21}, (a) -> (int) a > 5);
        p.summOfArrayElements(new int[]{3, 4, 5, 87, 21}, (a) -> (int) a < 5);
    }


}

class Pituh {
    public int summOfArrayElements(int[] arr, Predicate p) {
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





