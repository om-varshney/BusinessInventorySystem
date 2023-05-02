package Helpers;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeHelper {
    public static @NotNull String getCurrentDate() {
        // get the current date
        LocalDateTime currentDateTime = LocalDateTime.now();

        // format the date as per requirement
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // return the formatted date
        return currentDateTime.format(formatter);
    }
}
