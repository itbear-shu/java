package me.Interface02;

public class AnimalDemo {
    public static void main(String[] args) {
        Animal c = new Cat();
        c.eat();
        c.setAge(1);
        c.setName("江西");
        System.out.println(c.getAge() + " " + c.getName());

        Animal d = new Dog();
        d.eat();
    }
}
