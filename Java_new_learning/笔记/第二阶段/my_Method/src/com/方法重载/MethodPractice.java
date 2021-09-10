package com.方法重载;

public class MethodPractice {
    public static void main(String[] args) {
        System.out.println(compare(1, 1.0));
        System.out.println(compare((byte) 1, (byte) 1));
    }
    public static boolean compare(int a, int b){
        return a==b;
    }
    public static boolean compare(long a, long b){
        return a==b;
    }
    public static boolean compare(int a, long b){
        return a==b;
    }
    public static boolean compare(long a, int b){
        return a==b;
    }
    public static boolean compare(double a, double b){
        return a==b;
    }
    public static boolean compare(int a, double b){
        return a==b;
    }
    public static boolean compare(double a, int b){
        return a==b;
    }
    public static boolean compare(short a, short b){
        return a==b;
    }
    public static boolean compare(byte a, byte b){
        return a==b;
    }
}
