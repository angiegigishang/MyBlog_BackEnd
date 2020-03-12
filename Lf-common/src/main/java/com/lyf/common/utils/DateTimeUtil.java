package com.lyf.common.utils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {

    private static DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static DateTimeFormatter formatters2 = DateTimeFormatter.ofPattern("HHmmss");
    private static DateTimeFormatter formatters3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static CurrentDateTime getCurrent(){
        return new CurrentDateTime();
    }

    public static class CurrentDateTime {

        private Integer curDat;
        private Integer curTim;
        private Long timeStamp;
        private String datetime;

        public CurrentDateTime() {
            LocalDateTime now = LocalDateTime.now();
            this.curDat = Integer.valueOf(now.format(formatters));
            this.curTim = Integer.valueOf(now.format(formatters2));
            this.timeStamp = Timestamp.valueOf(now).getTime();
            this.datetime = now.format(formatters3);
        }

        public Integer getCurDat() {
            return curDat;
        }

        public Integer getCurTim() {
            return curTim;
        }

        public Long getTimeStamp() {
            return timeStamp;
        }

        public String getDatetime() {
            return datetime;
        }
    }





}
