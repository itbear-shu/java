package me.Abstract01;
/*
* 创建抽象类*/
public abstract class Animal {

    private int age = 20;
    private final String city = "上海";

    public Animal() {}

    public Animal(int age) {
        this.age = age;
    }

    //创建抽象方法
    public abstract void eat();

    public void sleep() {
        age = 40;
        System.out.println(age + ": " + city);
    }
}
