package xamples.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Collections {

    @Test
    public void test() {
        //Одна з реалізації колекції через ArrayList
        Collection<Integer> collection = new ArrayList<>();
        collection.add(48);
        collection.add(23);
        collection.add(55);
        System.out.println(collection.toString());

        //Ітератор шоб проходитись по колекціям
        Iterator<Integer> iterator = collection.iterator();
        while (iterator.hasNext())  {
            System.out.println(iterator.next());
        }




    }
}
