package me.Extend05;

public class Demo {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setAge(29);
        teacher.setName("yyy");
        System.out.println(teacher.getAge() + " " + teacher.getName());
        teacher.teach();
    }
}
