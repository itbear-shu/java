package day_5;

public class Person2 {
    String name;
    int age;
    String gender;

    public void study() {
        System.out.println("studying");
    }

    public void showAge() {
        System.out.println(age);
    }

    public int addAge(int i) {
        return age + i;
    }
}
