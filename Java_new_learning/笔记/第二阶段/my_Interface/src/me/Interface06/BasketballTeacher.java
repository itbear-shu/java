package me.Interface06;

public class BasketballTeacher extends Teacher{
    public BasketballTeacher() {
    }

    public BasketballTeacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("教学生打篮球");
    }

    @Override
    public void eat() {
        System.out.println("吃篮球教练餐");
    }
}
