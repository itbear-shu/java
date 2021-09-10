package me.itjx02;

public class Outer {
    private class Inner {
        public void show() {
            System.out.println("show");
        }
    }

    public void method() {
        Inner i = new Inner();
        i.show();
    }
}
