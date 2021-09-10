package me.itjx03;

public class AnimalDemo {
    public static void main(String[] args) {
        AnimalOperator ao = new AnimalOperator();
        AnInterface a = new AnInterfaceImpl();
        ao.useInterface(a);

        AnInterface a2 = ao.getInterface();
        a2.eat();
    }
}
