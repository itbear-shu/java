package me.Extend06;

public class Teacher extends Person{
    public Teacher(String name, int age){
        super(name, age);
    }
    public Teacher(){

    }
    public void teach(){
        System.out.println("教书育人");
    }

}
