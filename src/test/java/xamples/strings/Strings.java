package xamples.strings;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class Strings {

    String upperFluffer = "FLUFFER";

    String flufferWithSpaces = "Fluf fer ";


    //Генерим рендомну стрінгу
    public static String randomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        //Перебираємо стільки ітерацій на ту довжину яку на треба
        for (int i = 0; i < length; i++) {
            //Рендом буде генерити кожен раз інт який в баунді довжини строки
            int index = random.nextInt(str.length());
            //Тягнем зі строки її чар символ і додаємо дл стрінг білдера
            char symbol = str.charAt(index);

            sb.append(symbol);
        }
        return sb.toString();
    }


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

        String randomString = randomString(23);
        System.out.println(randomString);


        //Проходимся по всім чарам в стрінзі
        String base = "База для стрінги нашої укулеле";
        for(int i=0;i< base.length();i++)  {
            System.out.println(base.charAt(i));
        }


    }
}
