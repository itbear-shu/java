package me.Stirng02;

import java.util.Scanner;

public class String01 {
    public static void main(String[] args) {
        String name01 = "zjx";
        String code01 = "123456";
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i< 3;i++)
        {
            System.out.print("Please enter your username: ");
            String username = sc.nextLine();
            System.out.print("Please enter your code: ");
            String code = sc.nextLine();
            if( ! username.equals(name01) )
            {
                System.out.println("该用户名不存在！");
                System.out.println("你还有" + (2 - i) + "次机会");
                continue;
            }
            else if( ! code.equals(code01) )
            {
                System.out.println("密码错误！");
                System.out.println("你还有" + (2 - i) + "次机会");
                continue;
            }
            else if(username.equals(name01) && code.equals(code01))
            {
                System.out.println("Welcome!");
                break;
            }

        }
    }
}
