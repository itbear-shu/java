package me.Interface03;

public class Cat extends Animal implements Jumping{
    @Override
    public void jumping() {
        System.out.println("猫也会🐱跳");
    }

    @Override
    public void eat() {
        System.out.println("猫吃罐头o(=•ェ•=)m");
    }

    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }


}
