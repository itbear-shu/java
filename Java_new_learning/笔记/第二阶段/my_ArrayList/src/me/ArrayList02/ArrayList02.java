package me.ArrayList02;

import java.util.ArrayList;

public class ArrayList02 {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        array.add("C");
        array.add("python");
        array.add("java");

        array.remove("java");
        System.out.println(array);

        array.remove("javase");
        System.out.println(array);

        array.remove(1);
        System.out.println(array);
//
//        array.remove(3);
//        System.out.println(array);
        array.add("C");
        array.add("java");
        array.add("javase");
        array.remove("C");
        System.out.println(array);

        array.set(2, "python");
        System.out.println(array);
//
//        array.set(3, "python");
//        System.out.println(array);

        System.out.println(array.get(0));
        System.out.println(array.get(1));
        System.out.println(array.get(2));
//        System.out.println(array.get(3));//索引越界

        System.out.println("array.size(): " + array.size());
    }
}
