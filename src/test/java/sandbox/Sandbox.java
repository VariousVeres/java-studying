package sandbox;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

class Animal {
    void makeSound() {
        System.out.println("some sound");
    }
}

class Cat extends Animal {
    String name = "";

    Cat(String n) {
        name = n;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;
        return Objects.equals(name, cat.name);
    }

    public int hashCode()  {
        return Objects.hash(name);
    }

    @Override
    void makeSound() {
        System.out.println("murmur");
    }
}


public class Sandbox {

    @Test
    public void test() {

        Cat c1 = new Cat("Коля");
        Cat c2 = new Cat("Коля");

        System.out.println(c1.equals(c2));
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println("----------");



        List<String> l1 = new ArrayList<>();
        l1.add(0, "Me");
        l1.add(1, "You");
        l1.add(2, "God");
        l1.add("God");
        System.out.println(l1);

        Set<String> set = new HashSet<>(l1);

        System.out.println(set);



        List<String> l2 = new ArrayList<>();
        l2.add(0, "Me");
        l2.add(1, "God");
        l2.add(2, "You");
        l2.add( "Fred Durst");
        l2.add( "Bono");


        Comparator<String> com1 = (o1, o2)-> o1.compareTo(o2);
        Comparator<String> com2 = (o1, o2)-> o1.length() - o2.length();

        Collections.sort(l2, com1);
        System.out.println(l2);

        Collections.sort(l2, com2);
        System.out.println(l2);

    }


}



