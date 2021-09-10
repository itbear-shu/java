package me.Calender;

import java.util.Calendar;

public class CalenderDemo {
    public static void main(String[] args) {
        //获取对象；多态形式
        Calendar c = Calendar.getInstance();

//        int year = c.get(Calendar.YEAR);
//        int month = c.get(Calendar.MONTH) + 1;
//        int date = c.get(Calendar.DATE);
//        System.out.println(year + "-" + month + "-" + date);
        //2021-5-26

//        c.add(Calendar.YEAR, 1);
//        int year = c.get(Calendar.YEAR);
//        int month = c.get(Calendar.MONTH) + 1;
//        int date = c.get(Calendar.DATE);
//        System.out.println(year + "-" + month + "-" + date);
        //2022-5-26
        //set()方法
        c.set(2000, 10, 10);
        c.add(Calendar.YEAR, 1);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        System.out.println(year + "-" + month + "-" + date);
    }
}
