package day_5;

public class Teacher {
    private String name;
    private int age;
    private String course;
    private int tech_year;

    public Teacher() {
    }

    public Teacher(String name, int age, String course, int tech_year) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.tech_year = tech_year;
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

    public int getTech_year() {
        return tech_year;
    }

    public void setTech_year(int tech_year) {
        this.tech_year = tech_year;
    }
}
