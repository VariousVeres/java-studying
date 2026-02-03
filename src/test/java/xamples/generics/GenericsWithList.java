package xamples.generics;

import org.testng.annotations.Test;

import java.util.ArrayList;

import java.util.List;

/**
 * Дженеріки складніші приклади
 **/

public class GenericsWithList<T> {

    void printList(List<T> list) {
        for (T l : list)
            System.out.println("{" + l + "}");
    }


    private List<T> addToListAllTypes(List<T> list, T t) {
        list.add(t);
        System.out.println(list);
        return list;
    }

    @Test
    public void main() {
        GenericsWithList<String> gWL1 = new GenericsWithList<>();
        GenericsWithList<Integer> gWL2 = new GenericsWithList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        gWL2.printList(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("10");
        gWL1.printList(list2);


        List<String> list3 = new ArrayList<>();
        gWL1.addToListAllTypes(list3, "asd");

        List<Integer> list4 = new ArrayList<>();
        gWL2.addToListAllTypes(list4, 232);
    }


}