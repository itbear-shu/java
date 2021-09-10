package day_10;

import java.util.Scanner;

public class BankDemo {
    public static void main(String[] args) {
        //创建Scanner对象
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入卡号：");
        int number = sc.nextInt();

        //创建CheckingAccount对象
        CheckingAccount c = new CheckingAccount(number);
        c.deposit(100);
        //输入取钱金额
        System.out.println("请输入取钱金额：");
        double money = sc.nextDouble();
        try {
            c.withdraw(money);
        } catch (InsufficientFundsException e) {
            System.out.println("余额不足！" + "\n" + "你的余额剩余：" + c.getBalance());
        }
    }
}
