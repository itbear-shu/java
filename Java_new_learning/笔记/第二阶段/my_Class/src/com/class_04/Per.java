package com.class_04;

public class Per {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void show(){
        System.out.println(age + "--" + name);
    }
}
