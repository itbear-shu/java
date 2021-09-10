package me.StringBuilderPractice;

import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverse(s));
    }

    public static String reverse(String s){
//        StringBuilder sb = new StringBuilder(s);
//        return sb.reverse().toString();
        return new StringBuilder(s).reverse().toString();
    }
}
