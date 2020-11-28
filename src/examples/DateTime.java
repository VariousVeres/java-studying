package examples;
import org.junit.Test;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**Різні види часу та дати в Java - старий та новий**/

public class DateTime {

    @Test
    public void test() {
        /*З пакету java.util* - Date - старий формат дати*/

        Date dateObject = new Date();
        System.out.println(dateObject + " - Simple Date");

        /*З пакету java.text. можна юзати SimpleDateFormat - форматер, для якого підходить тільки new Date() з java.util*/
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy----MM-----dd:HH");
        String stringFromBasicDate = simpleFormat.format(dateObject);
//        String dateeString2 = simpleFormat.format(LocalDate.now()); //Видасть ерору
//        System.out.println(dateeString2);
        System.out.println(stringFromBasicDate);

        /*Щоб враховувати локаль ми юзаєм DateFormat з того ж пакету, але він виводить в одному вигляді -
        його не можна форматувати*/
        Locale loc = new Locale("fr", "FR");
        DateFormat dateFormatWithLocale = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
        String frenchStringDate = dateFormatWithLocale.format(new Date());
        System.out.println(frenchStringDate);

        /*А SimpleDateFormat можна форматувати і вивоити як хоч*/
        SimpleDateFormat simpleDateFormatWithLocale = new SimpleDateFormat("EEEEE MMMMM yyyy HH:mm:ss.SSSZ", new Locale("fr", "FR"));
        String date = simpleDateFormatWithLocale.format(dateObject);
        System.out.println(date);

        /*Новий пакет - java.time - LocalDate, LocalTime, LocalDateTime - новіші формати які представлені для Java 8*/
        LocalDate localDateObj = LocalDate.now(); // Дата
        System.out.println(localDateObj + " - Local Date");
        LocalTime localTimeObj = LocalTime.now(); // Час
        System.out.println(localTimeObj + " - Local Time");
        LocalDateTime localDateTimeObj = LocalDateTime.now(); // Дата і час
        System.out.println(localDateTimeObj + " - Local Date Time");

        /*З того ж пакету java.time юзаєм DateTimeFormatter - Форматуєм згідно кожен об'єкт по підходящому йому паттерну.
        Для дати дата, для часу час, дати і часу - дата і час*/
        DateTimeFormatter localDateFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        DateTimeFormatter localDateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        DateTimeFormatter localTimeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");

        String localDateString1 = localDateFormat.format(localDateObj);
        //Можна і навпаки
        String localDateString2 = LocalDate.now().format(localDateFormat);

        String localDateTimeString = localDateTimeFormat.format(localDateTimeObj);
        String localTimeString = localTimeFormat.format(localTimeObj);

        System.out.println(localDateString1 + " - Formatted local date string1");
        System.out.println(localDateString2 + " - Formatted local date string2");
        System.out.println(localTimeString + " - Formatted local time string");
        System.out.println(localDateTimeString + " - Formatted local date time string");
    }

}
