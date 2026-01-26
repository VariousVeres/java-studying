package xamples.generics;

import org.junit.Test;

class Client<K, V> {
    private K type;
    private V zone;
    public K getType() {
        return type;
    }
    public V getZone() {
        return zone;
    }
    public void setType(K type) {
        this.type = type;
    }

    public void setZone(V zone) {
        this.zone = zone;
    }
}

public class GenericWithMultipleTypes {


    @Test
    public void test() {
        // Отак можем викликати класи без типів при створенні через diamond operator new Client<>()
        Client<String, Integer> cl1 = new Client<>();
        cl1.setType("Zone");
        cl1.setZone(23);
        //Ставим типи які нам треба
        Client<Boolean, Float> cl2 = new Client();
        cl2.setZone(34.5f);
        cl2.setType(false);
    }
}
