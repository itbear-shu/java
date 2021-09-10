package com.me_03;

public class Method_03 {
    public static void main(String[] args) {
        isEvenNumber(10);
        get_Max(100, 200);
//        get_Max(100);
    }
    public static void isEvenNumber(int a) {
        if(a % 2 == 0){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
    public static void get_Max(int a, int b){
        if(a > b){
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}
