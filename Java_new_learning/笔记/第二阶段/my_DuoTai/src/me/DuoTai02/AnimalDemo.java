package me.DuoTai02;

public class AnimalDemo {
    public static void main(String[] args) {
        //创建动物操作类
        AnimalOperator ao = new AnimalOperator();
        Cat c = new Cat();
        ao.useAnimal(c);

        Dog d = new Dog();
        ao.useAnimal(d);
    }

}
