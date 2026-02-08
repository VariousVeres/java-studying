package xamples.generics.neww;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

class Gen<T, K> {
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

class GenChild<T,K> extends Gen<T, K>{
    public GenChild(T t, boolean b, K k) {
        super(t, b);
        super.setKey(k);
    }
}

class GenGrandChild<T,K, S> extends GenChild<T,K>{
    S style;
    public GenGrandChild(T t, boolean b, K k, S s) {
        super(t, b, k);
        this.style=s;
    }
}

public class GenericsWithInheritance {
    @Test
    public void test() {
        Gen<String, List<String>> stringGen = new Gen<>("Gen string", true);
        stringGen.setKey(new ArrayList<>());
        Gen<Boolean, int[]> booleanGen = new Gen<>(false, true);
        booleanGen.setKey(new int[4]);
        GenChild<Double, Integer> genChild1 = new GenChild<>(23.2d, true, 234);
        GenChild<String, Integer> genChild2 = new GenChild<>("Gen child string", true, 234);

        GenGrandChild<String, List<String>, Double> genGrandChild
                = new GenGrandChild<>("Grandchild string", true,new ArrayList<>(), 34.2d);
    }
}
