package day_10.TreeSet;

import java.util.Comparator;

public class Person implements Comparator<Person> {
    int age;
    String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    //想要让TreeSet按Person的age排序
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.age > o2.age) {
            return 1;
        } else if(o1.age < o2.age){
            return -1;
        } else
            return 0;
    }
}
