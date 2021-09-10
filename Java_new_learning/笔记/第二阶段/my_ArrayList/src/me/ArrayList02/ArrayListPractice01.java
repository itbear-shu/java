package me.ArrayList02;

import java.util.ArrayList;

public class ArrayListPractice01 {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("abc");
        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("java");
        arr.add("python");

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
