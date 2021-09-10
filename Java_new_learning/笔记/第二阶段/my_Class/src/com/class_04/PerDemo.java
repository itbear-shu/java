package com.class_04;

public class PerDemo {
    public static void main(String[] args) {
        Per p = new Per();

        p.setAge(100);
        p.setName("xiaomi");
        System.out.println(p.getAge());
        System.out.println(p.getName());
        p.show();
    }
}
