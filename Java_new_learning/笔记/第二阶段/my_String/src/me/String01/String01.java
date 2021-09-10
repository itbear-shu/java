package me.String01;

import java.util.Scanner;

public class String01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter a String: ");
        String line = sc.nextLine();
        //快捷键：ctrl+Alt+v
        String nextLine = sc.nextLine();
        System.out.println(nextLine);
        System.out.println("The String you enter is: " + line);
    }
}
