package me.Interface02;

public class InterfaceDemo {
    public static void main(String[] args) {
        Inter i = new InterImpl();
        System.out.println(i.num);
//        i.num = 10;
        System.out.println(i.num2);
        System.out.println(Inter.num2);
    }
}
