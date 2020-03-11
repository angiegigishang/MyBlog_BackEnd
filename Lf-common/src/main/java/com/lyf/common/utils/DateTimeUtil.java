package com.lyf.common.utils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    private static DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static DateTimeFormatter formatters2 = DateTimeFormatter.ofPattern("HHmmss");

    public static Integer currentDate() {
        LocalDate localDate = LocalDate.now();
        return Integer.parseInt(localDate.format(formatters));
    }

    public static Integer currentTime() {
        LocalTime localTime = LocalTime.now();
        return Integer.parseInt(localTime.format(formatters2));
    }


}
