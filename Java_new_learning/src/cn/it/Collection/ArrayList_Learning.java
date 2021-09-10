package cn.it.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author jx
 * @date 2021/8/23
 **/
public class ArrayList_Learning {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        Person p1 = new Person(1, "a");
        Person p2 = new Person(2, "b");
        Person p3 = new Person(3, "c");
        Person p4 = new Person(4, "d");
        Person p5 = new Person(5, "e");
        Person p6 = new Person(6, "f");
        Person p7 = new Person(7, "g");
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        printArrayList(list);

    }

    public static void printArrayList(ArrayList<Person> list) {
        String s = "{";
        for (int i = 0; i < list.size(); i++) {
            if(i != list.size() - 1) {
                s += list.get(i).toString() + "@";
            } else {
                s += list.get(i).toString();
            }
        }
        s += "}";
        System.out.println(s);
    }
}

