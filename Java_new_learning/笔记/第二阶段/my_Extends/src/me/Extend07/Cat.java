package me.Extend07;

public class Cat extends Animal{
    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    public void cat_catch_mouse(String name){
        System.out.println(name + "猫抓老鼠");
    }
}
