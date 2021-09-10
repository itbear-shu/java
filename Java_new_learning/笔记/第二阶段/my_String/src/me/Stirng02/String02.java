package me.Stirng02;

import java.util.Scanner;

public class String02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a line: ");
        String line = sc.nextLine();
        for(int i = 0;i < line.length();i++)
        {
            System.out.println(line.charAt(i));
        }
    }
}
