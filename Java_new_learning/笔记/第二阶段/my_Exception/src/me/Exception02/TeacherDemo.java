package me.Exception02;

import java.util.Scanner;

public class TeacherDemo {
    public static void main(String[] args) throws ScoreException {
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();
        Teacher t = new Teacher();
        t.checkScore(score);
    }
}
