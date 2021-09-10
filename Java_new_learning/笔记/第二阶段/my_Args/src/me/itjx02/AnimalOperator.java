package me.itjx02;

public class AnimalOperator {
    public void useAnimal(Animal a) {//需要该抽象类的子类对象
        a.eat();
    }

    public Animal getAnimal() {
        Animal a = new Cat();
        return a;//返回该抽象类的子类对象
    }
}
