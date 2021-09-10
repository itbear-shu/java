package day_14;

public class Student extends Person implements Study, Move{
    public int a;
    public String b;

    private int age;
    private String school;

    public Student() {
        System.out.println("调用public Student()");
    }

    public Student(String school) {
        this.school = school;
        System.out.println("1");
    }

    private Student(int age, String school) {
        this.age = age;
        this.school = school;
        System.out.println(2);
    }

    public void showInfo() {
        System.out.println("学校：" + school);
    }
    @Override
    public void moveType() {
        System.out.println("走路");
    }

    @Override
    public void study() {
        System.out.println("学习");
    }

    public void test(String name) {
        this.name = name;
        System.out.println(this.name);
    }

    public String getSchool() {
        return school;
    }

    private void test1(int age) {
        this.age = age;
        System.out.println(this.age);
    }
}
