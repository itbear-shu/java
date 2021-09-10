package me.ArrayList01;

import java.util.ArrayList;

public class ArrayListDemo01 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("C");
        arrayList.add("python");
        arrayList.add("java");
        System.out.println("arraylist: " + arrayList);

        arrayList.add(1, "javase");
        System.out.println("arraylist: " + arrayList);

        arrayList.add(4, "C++");
        System.out.println("arraylist: " + arrayList);

//        arrayList.add(5, "abc");
//        System.out.println("arraylist: " + arrayList);
    }
}
