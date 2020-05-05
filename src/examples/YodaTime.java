package examples;


import org.joda.time.DateTime;
import org.junit.Test;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.DateTimeZone;

import java.time.format.DateTimeFormatter;


public class YodaTime {

    @Test
    public void test() {

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateAndTime = LocalDateTime.now();

        //Можна перетворювати

        DateTime dateTime = currentDateAndTime.toDateTime();
        LocalDate localDate = currentDateAndTime.toLocalDate();
        LocalTime localTime = currentDateAndTime.toLocalTime();

        //Можна для локалі
        LocalDateTime currsentDate = LocalDateTime.now(DateTimeZone.forID("America/Chicago"));
        System.out.println(currsentDate);

        DateTimeFormatter dateTimeFormatter
                = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

        java.time.LocalDate dateo = java.time.LocalDate.now();
        String asd1 = dateTimeFormatter.format(dateo);
//        String asd2 = dateTimeFormatter.format(currentDate); А йода тайм сюда не засунеш


    }

}
