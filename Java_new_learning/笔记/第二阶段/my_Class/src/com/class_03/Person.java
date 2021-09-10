package com.class_03;

public class Person {
    private String name;
    private int age;

    public void setAge(int a) {
        if(a < 0){
            System.out.println("Error!");
        } else {
            age = a;
        }
    }
    public int getAge() {
        return age;
    }

    public void setName(String n) {
        name = n;
    }
    public String getName() {
        return name;
    }

    public void show() {
        System.out.println(name + "," + age);
    }
}
