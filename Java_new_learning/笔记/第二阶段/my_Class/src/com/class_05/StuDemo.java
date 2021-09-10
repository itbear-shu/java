package com.class_05;

public class StuDemo {
    public static void main(String[] args) {
        Stu s1 = new Stu();
        s1.show();
        s1.setName("xiaomi");
        s1.setAge(18);
        System.out.println(s1.getAge());
        System.out.println(s1.getName());
        Stu s2 = new Stu("xiaomi");
        s2.show();

        Stu s3 = new Stu(11);
        s3.show();


        Stu s4 = new Stu("xiaomi", 11);
        s4.show();

        //Stu s5 = new Stu(11, 'xiaomi');顺序要一致
    }
}
