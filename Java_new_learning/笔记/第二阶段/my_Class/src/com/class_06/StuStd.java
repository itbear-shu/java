package com.class_06;

public class StuStd {
    private String name;
    private int age;
    public StuStd() {

    }
    public StuStd(String name)
    {
        this.name = name;
    }
    public StuStd(int age)
    {
        this.age = age;
    }
    public StuStd(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public int getAge()
    {
        return age;
    }
    public void show()
    {
        System.out.println(name + "----" + age);
    }
}
