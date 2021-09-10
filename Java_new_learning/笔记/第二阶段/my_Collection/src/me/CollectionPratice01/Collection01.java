package me.CollectionPratice01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class Collection01 {
    public static void main(String[] args) {
        Collection<Student> c = new ArrayList<Student>();

//        Scanner sc = new Scanner(System.in);
        Student s1 = new Student("zjx", 10);
        Student s2 = new Student("jjj", 20);
        c.add(s1);
        c.add(s2);

        Iterator<Student> it = c.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
