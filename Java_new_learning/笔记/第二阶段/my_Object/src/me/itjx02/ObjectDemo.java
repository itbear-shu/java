package me.itjx02;


public class ObjectDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1.setAge(20);
        s1.setName("z");
        s2.setAge(20);
        s2.setName("z");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
