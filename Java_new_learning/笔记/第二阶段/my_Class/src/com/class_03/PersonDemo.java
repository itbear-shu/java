package com.class_03;

public class PersonDemo {
    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(100);
        p.setName("xiaomi");
        p.show();

        System.out.println(p.getAge() + "----" + p.getName());
    }
}
