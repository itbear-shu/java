package me.itjx03;

public class AnimalOperator {
    public void useInterface(AnInterface a) {
        a.eat();
    }

    public AnInterface getInterface() {
        AnInterface a = new AnInterfaceImpl();
        return a;
    }

}
