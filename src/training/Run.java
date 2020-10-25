package training;

import java.util.function.Predicate;

import org.junit.Test;


/**ДЖЕНЕРІКИ**/
/** ЗАСТОСУВАННЯ Ф-ЦІОНАЛЬНИХ ІНТЕРФЕЙСІВ**/


public class Run {
    @Test
    public void main() {
        Predicate<Integer> p = (a) -> (a % 2) == 0;
        Pituh.summOfArrayElements(new int[]{3, 4, 5, 6,34}, (a) -> (Integer) a % 2 == 0);

        Generic<Integer> gem = new Generic<>();
        gem.method(34);
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


class Generic <T> {
    public void method(T t)  {
        System.out.println(t);
    }
}

