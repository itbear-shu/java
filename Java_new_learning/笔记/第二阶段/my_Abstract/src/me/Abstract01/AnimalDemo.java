package me.Abstract01;

public class AnimalDemo {
    public static void main(String[] args) {
        //抽象类不能直接创建对象
//        Animal a = new Animal();
        //借助多态的方法
        Animal a = new Cat();
        a.eat();

        a.sleep();

    }
}
