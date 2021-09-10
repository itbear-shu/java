package me.Interface06;

public class PingpongTeacher extends Teacher implements SpeakEnglish{
    public PingpongTeacher() {
    }

    public PingpongTeacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void teach() {
        System.out.println("教学生打乒乓球");
    }

    @Override
    public void eat() {
        System.out.println("吃乒乓球教练餐");
    }

    @Override
    public void SpEng() {
        System.out.println("乒乓球教练也要说英语");
    }
}
