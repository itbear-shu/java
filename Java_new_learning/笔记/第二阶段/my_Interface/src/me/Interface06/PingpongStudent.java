package me.Interface06;

public class PingpongStudent extends Student implements SpeakEnglish{
    public PingpongStudent() {
    }

    public PingpongStudent(String name, int age) {
        super(name, age);
    }

    @Override
    public void study() {
        System.out.println("学习打乒乓球");
    }

    @Override
    public void eat() {
        System.out.println("吃乒乓球");
    }

    @Override
    public void SpEng() {
        System.out.println("乒乓球运动员也要学习英语");
    }
}
