package day_6;

import day_6.TriAngle;

public class TriAngleTest {
    public static void main(String[] args) {
        TriAngle t = new TriAngle(1, 2);
        System.out.println(t.getBase() * t.getHeight() * 0.5);
    }
}
