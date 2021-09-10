package me.Final2;

public class FinalDemo {
    public static void main(String[] args) {
        //final修饰基本类型，数据值不能变
        final int age = 10;
//        age = 100;
        System.out.println(age);

        //final修饰引用类型，地址值不能变，但内容可变
        final Student st = new Student();
        st.age = 20;
        System.out.println(st.age);
//        st = new Student();
    }
}
