package com.me_01;
import java.util.Scanner;
public class Method_01 {
        public static void main(String[] args) {
            isEvenNumber();
        }
        public static void isEvenNumber() {
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            if(x % 2 == 0)
            {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
}
