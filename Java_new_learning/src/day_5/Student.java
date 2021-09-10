package day_5;

public class Student {
    private String name;
    private int age;
    private String course;
    private String interest;

    public Student() {
    }

    public Student(String name, int age, String course, String interest) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.interest = interest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
