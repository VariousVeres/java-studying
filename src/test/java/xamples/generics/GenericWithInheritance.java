package xamples.generics;

import org.junit.Test;

class Human<L> {
    private L race;
    public void setRace(L race) {
        this.race = race;
    }
    public L getRace() {
        return race;
    }
}

//Якщо наслідуватись то дочірній клас не знає про інший по типу дженерік батьківського - треба вказувати
class Person<G, L> extends Human<L> {
    private G id;
    private String name;
    G getId() {
        return id;
    }

    //Метод де ми передаєм ще якийсь тип всередину
    <H> G getId(H addon) {
        System.out.println("Оце отаке " + addon);
        return id;
    }
    Person(G id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class GenericWithInheritance {

    @Test
    public void test() {
        //Створюєм об'єкт з потрібними нами типами - <Boolean,Integer> обов'язково
        Person<Boolean, Integer> person = new Person<>(true, "Name");

        person.setRace(34);
        System.out.println(person.getId());
        System.out.println(person.getRace());


    }
}
