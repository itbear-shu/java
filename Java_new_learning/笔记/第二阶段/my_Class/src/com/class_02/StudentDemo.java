package com.class_02;

public class StudentDemo {
    public static void main(String[] args) {
        Student stu = new Student();
        System.out.println(stu);
        stu.age = 19;
        stu.name = "zjx";

        System.out.println(stu.age);
        System.out.println(stu.name);

        stu.study();
        stu.doHomework();
    }
}
