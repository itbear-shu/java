package com.class_05;

public class Stu {

    private String name;
    private int age;

    public Stu() {

    }

    public Stu(String name) {
        this.name = name;
    }

    public Stu(int age) {
        this.age = age;
    }

    public Stu(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void show() {
        System.out.println(name + ", " + age);
    }
}
