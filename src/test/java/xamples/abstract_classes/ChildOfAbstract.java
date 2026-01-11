package xamples.abstract_classes;

public class ChildOfAbstract extends AbstractClass {
    public ChildOfAbstract(String name, int age) {
        super(name, age);
    }

    //Реалізація анонімного методу (Без цього не створиться клас)
    @Override
    public void sayAge() {
        System.out.println("My age is " + getAge());
    }


}
