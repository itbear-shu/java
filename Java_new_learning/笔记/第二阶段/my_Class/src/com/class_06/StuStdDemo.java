package com.class_06;

public class StuStdDemo {
    public static void main(String[] args) {
        StuStd s1 = new StuStd("zjx", 19);
        s1.show();
        StuStd s2 = new StuStd(19);
        s2.show();
        System.out.println(s2.getAge());
    }
}
