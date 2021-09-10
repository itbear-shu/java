package com.class_01;

public class PhoneDemo {
    public static void main(String[] args) {
        Phone p = new Phone();
        System.out.println(p.brand);
        System.out.println(p.price);

        p.brand = "xiaomi";
        p.price = 2999;
        System.out.println(p.brand);
        System.out.println(p.price);

        p.call();
        p.sendMessage();
    }
}
