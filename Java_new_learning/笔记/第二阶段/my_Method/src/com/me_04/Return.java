package com.me_04;

public class Return {
    public static void main(String[] args) {
        boolean flag = isEvenNumber(10);
        System.out.println(flag);
        System.out.println(isEvenNumber(10));
        int max = get_Max(10, 20);
        System.out.println(max);
        System.out.println(get_Max(10, 20));
    }
    public static boolean isEvenNumber(int n){
        if(n%2 == 0)
        {
            return true;
        }
        else {
            return false;
        }
    }
    public static int get_Max(int a, int b){
        if(a > b){
            return a;
        } else {
            return b;
        }
    }
}
