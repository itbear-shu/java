package me.itjx01;

public class Outer {
    private int num = 10;
    //内部类可直接方位外部对象
    public class Inner {
        public void show() {
            System.out.println(num);
        }
    }
    //外部类要访问内部类，需创建对象
    public void method() {
        Inner i = new Inner();
        i.show();
    }
}
