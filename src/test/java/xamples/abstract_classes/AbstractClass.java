package xamples.abstract_classes;

abstract class AbstractClass {
   private String name;

    private int age;
    //Є конструктор для наслідування
    public AbstractClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Є логіка яка реалізована в класі
    public void sayName() {
        System.out.println("My name is " + name);
    }

    //Є метод, який по контракту має бути реалізований при наслідуванні
    public abstract void sayAge();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
