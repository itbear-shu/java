package me.Interface02;

public interface Inter {
    //接口类的成员变量默认为final修饰
//    public int num = 10;
    int num = 10;
//    public final int age = 19;
    int age = 19;
//    public static final int num2 = 10;
    int num2  = 10;


    //不能有构造方法
//    public Inter() {}
    //成员方法：只允许抽象方法
    public abstract void show();
    //默认抽象方法
//    public abstract void sell();
    void sell();
}
