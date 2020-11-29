package examples;

import org.junit.Test;

import java.util.ArrayList;

import java.util.List;

/**
 * Дженеріки складніші приклади
 **/

public class Generics2 {
    //1) Wildcards або метасимвольні аргументи, я хз нашо воно, але типу так ми можем передавати любі типи
    static void printList(List <?> list) {
        for (Object l : list)
            System.out.println("{" + l + "}");
    }

    //2) Метод, який примає ліст певного типу і змінну того ж
    // Перше <T> - це визначає що ми юзаєм дженерік в методі, друге List<T> - визначає що ми повертаєм
    private <T> List<T> addToListAllTypes(List<T> list, T t) {
        list.add(t);
        System.out.println(list);
        return list;
    }

    @Test
    public void main() {
        //1) Типу лісти з різними типами можем передавати сюди
        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        printList(list1);
        List<String> list2 = new ArrayList<>();
        list2.add("10");
        printList(list2);

        //2) Але ми ітак можем передавати лісти різних типів
        List<String> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        addToListAllTypes(list3, "asd");
        addToListAllTypes(list4, 232);
    }


}