package training;


import org.junit.Test;

interface Face<T> {
    T getValue();
}


class FaceImpl<T> implements Face {
    T str;

    @Override
    public Object getValue() {
        return str;
    }
}

public class Run3 {
    @Test
    public void main() {
        FaceImpl<String> fImpl = new FaceImpl<>();
        System.out.println(fImpl.getValue());


    }

}



