package com.method_change;

public class Method_Change1 {
    public static void main(String[] args) {
        int number = 20;
        System.out.println("number: " + number);
        change(number);
        System.out.println("number: " + number);
    }
    public static void change(int number){
        number = 200;
    }
}
