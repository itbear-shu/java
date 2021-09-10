package me.Interface06;
//定义抽象人类
public abstract class Human {
    private String name;//定义姓名
    private int age;//定义年龄

    public Human() {
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

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void eat();
}
