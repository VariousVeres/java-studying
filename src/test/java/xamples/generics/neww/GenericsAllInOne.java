package xamples.generics.neww;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Дженерік клас
class Structure<T> {
    private T time;

    String labor;

    Structure(T t, String l) {
        time = t;
        labor = l;
    }
}

//Наслідування від дженерік класу
class Form<T, J> extends Structure<T> {
    J join;

    public Form(T t, J j) {
        super(t, "String");
        join = j;
    }
}

class Seclusion {
    //Дженерік метод
    public static <T> void method(T t) {
        System.out.println(t);
    }

    // List<T>
    public static <T> void listMeth(List<T> list,T t)  {
        list.add(t); //Можем додати бо при виклику будем знати типу
        System.out.println(list.get(0));
        System.out.println(list);
    }

    /**Яка різниця між <T> void listMeth(List<T> list,T t)  і  public static void listMetho(List<?> list) **/

    // List<?>
    public static void listMetho(List<?> list)  {
//        list.add(t);  - тут не можемо додати бо не знаємо взагалі тип
        System.out.println(list.get(0));
        System.out.println(list);
    }

    //Тут продукуємо значення потомків Number
    public static void listMeth(List<? extends Number> list)  {
        System.out.println(list.get(0));
//        list.add(34); - Не канає бо знаємо що типу наслідуєтсья від Number, а вдруг буде Float
        System.out.println(list);
    }

    //Тут споживаємо значення Integer або його батьків
    public static void listMethy(List<? super Integer> list)  {
        System.out.println(list.get(0));

        list.add(list.size()  ,700); // А отут все ок бо Integer точно по типу влізе в бактьківський тип
        System.out.println(list);
    }


}


public class GenericsAllInOne {
    @Test
    public void test() {
        Structure<String> s1 = new Structure<>("String", "Labor");
        Structure<Integer> s2 = new Structure<>(32, "Labor");
        Form<Integer, Double> s3 = new Form<>(32, 22.4);

        Seclusion.method(23);
        Seclusion.method(Arrays.asList("12", 3, true));


        List<Integer> list = new ArrayList<>(12);
        list.add(0, 34);
        list.add(1, 34);
        list.add(2, 35);
        list.add(3, 17);

        Seclusion.listMeth(list, 18);

        Seclusion.listMetho(List.of(24,24,24));
        Seclusion.listMeth(List.of(21.6,7.5,-14));

        Seclusion.listMethy(list);

    }

}
