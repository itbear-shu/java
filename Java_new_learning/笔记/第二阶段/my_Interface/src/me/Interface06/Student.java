package me.Interface06;

public abstract class Student extends Human{
    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    public abstract void study();
}
