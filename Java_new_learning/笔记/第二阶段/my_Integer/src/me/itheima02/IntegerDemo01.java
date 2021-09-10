package me.itheima02;

public class IntegerDemo01 {
    public static void main(String[] args) {
        Integer i = 10;//自动装箱
        Integer ii = Integer.valueOf(10);//装箱
        i += 200;//自动拆箱
        ii = ii.intValue() + 200;//拆箱

        Integer iii = null;//做部位null的判断
        if(iii != null) {
            iii += 20;
        }
    }
}
