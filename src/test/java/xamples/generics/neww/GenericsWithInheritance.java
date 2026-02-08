package xamples.generics.neww;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

class Gen<T extends Number, K> {
    private T type;
    private K key;
    private boolean isMatch;

    Gen(T t, boolean m) {
        this.type = t;
        this.isMatch = m;
    }

    public void setKey(K k) {
        this.key=k;
    }

    public T getType() {
        return type;
    }

    public boolean getIsMatch() {
        return isMatch;
    }

    public K getKey() {
        return key;
    }

}

class GenChild<T extends Integer ,K> extends Gen<T, K>{
    public GenChild(T t, boolean b, K k) {
        super(t, b);
        super.setKey(k);
    }
}

class GenGrandChild<T extends Integer,K, S> extends GenChild<T,K>{
    S style;
    public GenGrandChild(T t, boolean b, K k, S s) {
        super(t, b, k);
        this.style=s;
    }
}

public class GenericsWithInheritance {
    @Test
    public void test() {
        //Тут перший параметр типу T має бути extends Number, другий boolean, але ще є тип K який ми в даймонді кажем який саме - List<String>
        Gen<Long, List<String>> stringGen = new Gen<>(123L, true);
        stringGen.setKey(new ArrayList<>());
        //Тут перший параметр типу T має бути extends Number, другий boolean, але ще є тип K який ми в даймонді кажем який саме - int[]
        Gen<Integer, int[]> booleanGen = new Gen<>(22, true);
        booleanGen.setKey(new int[4]);

        //Тут перший параметр типу T має бути extends Integer, другий boolean, третій типу K ми кажем що String
        GenChild<Integer, String> genChild1 = new GenChild<>(23, true, "kkk");

        //Тут перший параметр має бути extends Integer, другий boolean, третій типу K ми кажем що boolean[]
        GenChild<Integer, boolean[]> genChild2 = new GenChild<>(33, true, new boolean[2]);


        GenGrandChild<Integer, List<String>, Double> genGrandChild
                //ут перший параметр має бути extends Integer, другий boolean, третій типу K ми кажем що List<String>, четвертий типу S ми кажемо що Double
                = new GenGrandChild<>(33, true,new ArrayList<>(), 34.2d);
    }
}
