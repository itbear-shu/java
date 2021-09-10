package me.Interface03;

public class InterDemo {
    public static void main(String[] args) {
        Animal cat = new Cat("jj", 10);
        System.out.println(cat.getAge() + ": " + cat.getName());
        cat.eat();

        Animal dog = new Dog("mm", 11);
        System.out.println(dog.getAge() + ": " + dog.getName());
        dog.eat();

        Jumping j1 = new Cat("jj", 1);
        j1.jumping();

        Jumping j2 = new Dog("kk", 2);
        j2.jumping();
        //最常用
        Cat c =new Cat("oo", 3);
        c.eat();
        c.jumping();
    }
}
