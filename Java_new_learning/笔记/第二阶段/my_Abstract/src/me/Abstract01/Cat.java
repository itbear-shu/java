package me.Abstract01;

public class Cat extends Animal{
    //抽象类的子类重写抽象方法
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
