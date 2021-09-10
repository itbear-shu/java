package me.Interface02;

public class InterImpl extends Object implements Inter{
    //默认继承Object类
    public InterImpl() {
        super();
    }
    @Override
    public void show() {
        System.out.println("show");
    }

    @Override
    public void sell() {

    }
}
