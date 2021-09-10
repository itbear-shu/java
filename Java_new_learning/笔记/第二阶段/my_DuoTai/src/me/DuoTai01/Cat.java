package me.DuoTai01;

//有继承
public class Cat extends Animal {

    public int age = 5;
    public int weight = 5;

    //方法重写
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }

    public void play() {
        System.out.println("猫玩游戏");
    }
}
