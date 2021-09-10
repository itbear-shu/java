package me.Stirng02;

import java.util.Scanner;

public class String05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a String: ");
        String line = sc.nextLine();
        String fline = reverse(line);
        System.out.println(fline);

    }
    public static String reverse(String line)
    {
        String s = "";
        for(int i = line.length() - 1 ;i >= 0;i--)
        {
            s += line.charAt(i);
        }
        return s;
    }

}
