package me.Exception01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exception02 {
    public static void main(String[] args) {
        System.out.println("begin");
        try {
            method3();
        } catch (ArrayIndexOutOfBoundsException a){
            a.printStackTrace();
        }

        System.out.println("end");
    }

//    public static void method2() throws ParseException {
//        String s = "2000-10-10";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date parse = sdf.parse(s);//编译时异常
//        System.out.println(parse);
//    }
//    public static void method() {
//        try {
//            int[] arr = {1, 2, 3};
//        } catch (ArrayIndexOutOfBoundsException a) {
//            a.printStackTrace();//运行时异常
//        }
//    }
    public static void method3() throws ArrayIndexOutOfBoundsException{
        int[] arr = {1, 2, 3};
        System.out.println(arr[4]);
    }
}
