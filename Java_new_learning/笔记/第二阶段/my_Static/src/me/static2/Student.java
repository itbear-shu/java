package me.static2;

public class Student {
    public String name = "zjx";
    public int age = 10;

    public void show1(){

    }
    public void show2(){
        System.out.println(name);
        System.out.println(age);
        show1();
        show3();
        show4();
    }

    public static void show3(){

    }
    public static void show4(){
//        System.out.println(name);
//        System.out.println(age);
//        show1();
        show4();
    }
}
