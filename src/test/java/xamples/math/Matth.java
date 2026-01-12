package xamples.math;

import org.junit.Test;

import java.math.BigInteger;

public class Matth {
    @Test
    public void test() {
        double randomDouble = Math.random();
        System.out.println("Random double " + randomDouble);
        float floatFromDouble = (float) randomDouble;
        System.out.println("Float from random fouble " + floatFromDouble);
        int intFromDouble = (int) randomDouble;
        System.out.println("Integer from random fouble " + intFromDouble);

        System.out.println("Більше з двох чисел " + Math.max(2, 3));

        //Для більшої точності
        BigInteger bigIntegerA = BigInteger.valueOf(42);
        BigInteger bigItBigIntegerB = bigIntegerA.add(bigIntegerA);
        BigInteger bigIntegerC = bigIntegerA.multiply(bigIntegerA);

        System.out.println(bigIntegerC);

    }
}
