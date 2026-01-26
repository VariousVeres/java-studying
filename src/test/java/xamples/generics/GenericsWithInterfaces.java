package xamples.generics;

import org.junit.Test;


interface Buyer<F, V> {
    void setName(F name);

    V getLabel();
}

class Tenant<F, V> implements Buyer<F, V> {
    F name;
    V label;

    @Override
    public void setName(F name) {
        this.name = name;
    }

    @Override
    public V getLabel() {
        return this.label;
    }
}


public class GenericsWithInterfaces {
    @Test
    public void test() {

    }
}
