package day_5;

public class Person4 {
    private int age;
    private String name;

    public Person4(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person4(String name) {
        this.name = name;
    }

    public Person4(int age) {
        this.age = age;
    }

    public Person4() {
    }

    public int x;
    public int y;
    public int z;

    public Person4(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setPoint(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
