package com.方法重载;

public class Method_05 {
    public static void main(String[] args) {
        int s = sum(1, 2);
        System.out.println(s);
        double s2 = sum(1.0, 2.0);
        System.out.println(s2);
        int s3 = sum(1, 2, 3);
        System.out.println(s3);
    }
    public static int sum(int a, int b){
        return a + b;
    }
    public static double sum(double a, double b){
        return a + b;
    }
    public static int sum(int a, int b, int c){
        return a + b + c;
    }
}

