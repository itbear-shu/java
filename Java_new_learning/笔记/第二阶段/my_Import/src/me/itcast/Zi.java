package me.itcast;

public class Zi extends Fu{
    public static void main(String[] args) {
        //子类不能访问父类中的private修饰的方法
        Zi z = new Zi();
        z.show2();
        z.show3();
        z.show4();
    }
}
