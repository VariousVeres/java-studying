package xamples.strings;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Strings {

    String upperFluffer = "FLUFFER";

    String flufferWithSpaces = "Fluf fer ";


    @Test
    public void test() {
        String fluffer = "Fluffer";
        String fluffer1 = "Fluffer";
        //Зрівнюємо строки
        System.out.println(fluffer.equals(fluffer1));
        //Зрівнюємо строки ігноруючи регістр
        System.out.println(fluffer.equalsIgnoreCase(upperFluffer));
        //Забираємо пробіли
        System.out.println(flufferWithSpaces.replace(" ", ""));
        //Розбиваємо строку на масив
        String[] flufferWithSpacesArray = fluffer.split("\\s");
        System.out.println(Arrays.toString(flufferWithSpacesArray));

        //не получиться рівняти == в такому випадку
        String murzik = "Мурзік";
        String murzik2 = new String(murzik);
        System.out.println(murzik == murzik2);

        //Перетворюємо на масив чарів
        char[] arr = murzik.toCharArray();
        System.out.println(Character.getName(arr[5]));
        //Знаходимо по стрінзі який її індекс
        System.out.println(murzik.indexOf("зі"));

    }
}
