package day_10.TreeSet;

import java.util.Set;
import java.util.TreeSet;

public class Test03 {
    public static void main(String[] args) {
        Person p1 = new Person(25, "zjx");
        Person p2 = new Person(22, "zju");
        Person p3 = new Person(21, "zjr");
        Person p4 = new Person(23, "zjq");

        Set<Person> set = new TreeSet<Person>(new Person());

        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);

        for (Person p: set
             ) {
            System.out.println(p.name + ":  " + p.age);
        }
    }
}
