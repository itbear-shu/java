package me.Extend07;

public class AnimalDemo {
    public static void main(String[] args) {
        //创建Cat类
        Cat c1 = new Cat();
        c1.setAge(1);
        c1.setName("kk");
        c1.show();
        c1.cat_catch_mouse(c1.getName());
        Cat c2 = new Cat("yy", 1);
        c2.show();

        //创建Dog类
        Dog d1 = new Dog();
        d1.setAge(10);
        d1.setName("jj");
        d1.show();
        d1.kandoor();

    }
}
