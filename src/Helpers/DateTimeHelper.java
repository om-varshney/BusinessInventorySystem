package Helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {
    public static String getCurrentDate() {
        // get the current date
        LocalDate currentDate = LocalDate.now();

        // format the date as per requirement
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // return the formatted date
        return currentDate.format(formatter);
    }
}
