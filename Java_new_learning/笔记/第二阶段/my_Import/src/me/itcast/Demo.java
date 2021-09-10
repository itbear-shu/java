package me.itcast;

public class Demo {
    public static void main(String[] args) {
        //同一个包下，没有任何关系的也可以访问后三者
        Fu f = new Fu();
        f.show2();
        f.show3();
        f.show4();
    }
}
