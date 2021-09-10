package me.Extend03;

public class Zi extends Fu{
    public Zi(){
        super();
        System.out.println("子类无参构造方法被调用");
    }
    public Zi(int age){
        super(20);
        System.out.println("子类带参构造方法被调用");
    }
}
