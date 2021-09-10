package me.SimpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SDF {
    public static void main(String[] args) throws ParseException {
        Date d1 = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat();//默认格式
        String format1 = sdf1.format(d1);//格式化:从Data到String
        System.out.println(format1);

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");//自己设定格式
        String format2 = sdf2.format(d1);
        System.out.println(format2);

        //解析：从String到Date
        String s = "2019年12月20日 11:22:60";
        Date parse = sdf2.parse(s);
        System.out.println(parse);
    }
}
