package me.Interface03;

public class Dog extends Animal implements Jumping{
    @Override
    public void jumping() {
        System.out.println("狗跳跳🐕");
    }

    @Override
    public void eat() {
        System.out.println("狗不吃骨头U•ェ•*U");
    }

    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }


}
