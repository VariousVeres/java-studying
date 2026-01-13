package xamples.collections;

import org.junit.Test;

import java.util.LinkedList;

public class LinkedLists {

    @Test
    public void test() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Ісус");
        linkedList.add("Робокоп");
        linkedList.add("Раб божий");
        linkedList.add("Людовік");
        linkedList.add("Мікі 17");

        System.out.println(linkedList);
    }
}
