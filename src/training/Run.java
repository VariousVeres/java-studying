package training;
import org.junit.Test;


interface Inter {
    boolean method(int a);
}

class ExpressionHelper {
    static boolean isPair(int j) {
        return j % 2 == 0;
    }

    static boolean isUnPair(int j) {
        return j % 2 == 1;
    }
}


public class Run {

    //    Inter lambda = (int a) -> a % 2 == 0;
    int[] arr = new int[]{2, 3, 4, 56, 23, 8, 7, 11, 12, 35};

    int sumOf(int[] arr, Inter itn) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if (itn.method(arr[i])) {
                counter += arr[i];
            }
        }
        return counter;
    }


    @Test
    public void test1() {
        System.out.println(sumOf(arr, ExpressionHelper::isPair));
        System.out.println(sumOf(arr, ExpressionHelper::isUnPair));
    }

}
