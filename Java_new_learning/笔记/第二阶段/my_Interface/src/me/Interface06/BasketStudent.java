package me.Interface06;

public class BasketStudent extends Student{
    public BasketStudent() {
    }

    public BasketStudent(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("学习打篮球");
    }

    @Override
    public void eat() {
        System.out.println("吃篮球");
    }
}
