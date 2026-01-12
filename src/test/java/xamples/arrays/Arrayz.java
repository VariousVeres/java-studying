package xamples.arrays;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Arrayz {
    @Test
    public void test() {

        //По одному оголосили
        char[] charArray = new char[5];
        charArray[0] = 72;
        System.out.println(charArray[0]);
        System.out.println((int) charArray[0]);

        //По іншому оголосили і перебрали
        String[] stringArray = {"Павел", "Іван", "Христос", "Антоніо Бандерас"};
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }

        //Показуємо що по змінній не канає копіювати
        int[] anyNumbers = {2, 8, 11};
        int[] luckyNumbers = anyNumbers;
        luckyNumbers[2] = 25;

        System.out.println(anyNumbers[2]);
        System.out.println(luckyNumbers[2]);

        //Для операцій з масивами типу додати, копіювати юзається System.arrayCopy

        //Додати два масиви - треба створити новий масив з довжиню рівною сумою довжин двох двох і копіювати
        String[] stringArray2 = {"Іуда", "Понтій пилат"};

        String[] sumResultArray = new String[stringArray.length + stringArray2.length];

        System.arraycopy(stringArray, 0, sumResultArray, 0, stringArray.length);
        System.arraycopy(stringArray2, 0, sumResultArray, stringArray.length, stringArray2.length);
        System.out.println(Arrays.toString(sumResultArray));

        //Але є окрема ліба Arrays
        //Вона копіює
        String[] copyOfArrayPart = Arrays.copyOf(sumResultArray, 2);
        // Виводить всі елементи
        System.out.println("Масив вивели значення -" + Arrays.toString(copyOfArrayPart));

        //Перевіряє на ідентичність масиви
        int[] array1 = {6, 6, 6};
        int[] array2 = {6, 6, 6};
        int[] array3 = {6, 7, 6};
        System.out.println(Arrays.equals(array1, array2));
        System.out.println(Arrays.equals(array1, array3));

        //Робить з масиву колекцію
        List<String> listFromArray = Arrays.asList(sumResultArray);
        System.out.println("Ліст вивели значення - " + listFromArray + ", і тип - "+ listFromArray.getClass());

        //Сортує масив quick sort
        Arrays.sort(sumResultArray);
        System.out.println(Arrays.toString(sumResultArray));


        //Максимальне значення масивву
        int[] mice = new int[] { 4, 9, 3, 22, 5, 18, 25, 7, 11, 15, 5, 19 };


        int max = mice[0];
        for (int i=1;i<mice.length;i++)   {
            if(mice[i]> max)  {
                max = mice[i];
            }
        }
        System.out.println("Макс - "+ max);



    }
}
