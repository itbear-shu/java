package me.DuoTai01;

public class DuoTaiDemo01 {
    public static void main(String[] args) {
        //父类引用指向子类对象
        Animal a = new Cat();
        //成员变量:编译看左边，执行看右边
        System.out.println(a.age);
//        System.out.println(a.weight);
        //成员方法：编译看左边，执行看右边
        a.eat();
//        a.play();

    }
}
