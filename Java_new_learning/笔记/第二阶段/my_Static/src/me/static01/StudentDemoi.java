package me.static01;

public class StudentDemoi {
    public static void main(String[] args) {

        Student.university = "SHU";

        Student s1 = new Student();
        s1.age = 20;
        s1.name = "jjj";
//        s1.university = "SHU";
        s1.show();

        Student s2 = new Student();
        s2.age = 19;
        s2.name = "lll";
//        s2.university = "PKU";
        s2.show();
    }
}
