package me.SimpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtilsDemo {
    public static void main(String[] args) throws ParseException {
        Date d1 = new Date();
        DateUtils dateUtils = new DateUtils();
        String s1 = "2019-10-10 19:10:05";
        System.out.println(dateUtils.dataToString(d1, "yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateUtils.stringToDate(s1, "yyyy-MM-dd HH:mm:ss"));
    }
}
