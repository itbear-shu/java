package me.Stirng02;

import java.util.Scanner;

public class String03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int u_alphas = 0;
        int l_alphas = 0;
        int digits = 0;
        int others = 0;
        for(int i = 0;i < line.length();i++)
        {
            if(line.charAt(i) >= 'A' && line.charAt(i) <= 'Z')
            {
                u_alphas++;
            }
            else if(line.charAt(i) >= 'a' && line.charAt(i) <= 'z')
            {
                l_alphas++;
            }
            else if(line.charAt(i) >= '0' && line.charAt(i) <= '9')
            {
                digits++;
            }
            else {
                others++;
            }
        }
        System.out.println("upper words: " + u_alphas);
        System.out.println("lower words: " + l_alphas);
        System.out.println("digits: " + digits);
        System.out.println("others: " + others);
    }
}
