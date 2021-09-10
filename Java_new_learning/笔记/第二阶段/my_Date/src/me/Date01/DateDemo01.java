package me.Date01;

import java.util.Date;

public class DateDemo01 {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);

        Date d2 = new Date(1000*60*60*2);
        System.out.println(d2);

        Date d3 = new Date();
        System.out.println(d3.getTime());//1970

        Date d4 = new Date();
        d4.setTime(1000*60*60*4);
        System.out.println(d4);

        Date d5 = new Date();
        long time = System.currentTimeMillis();
        d5.setTime(time);
        System.out.println(d5);
    }
}
