package day_15.Test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        Thread t1 = new Thread(new DisplayMessage("abab"));
//        t1.start();
//
//        Thread t2 = new Thread(new DisplayMessage("cdcd"));
//        t2.start();

//        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();
        Thread t3 = new GuessANumber(10);
        t3.start();
    }
}
