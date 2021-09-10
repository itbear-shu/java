package com.method_change;

public class Method_Change2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        change(arr);
        System.out.println("arr[1] = " + arr[1]);
    }
    public static void change(int[] arr){
        arr[1] = 20;
    }
}

