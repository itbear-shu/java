package me.Interface06;

public abstract class Teacher extends Human{
    public Teacher() {
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    public abstract void teach();
}
