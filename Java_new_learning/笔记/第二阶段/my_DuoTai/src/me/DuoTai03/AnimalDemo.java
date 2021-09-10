package me.DuoTai03;

public class AnimalDemo {
    public static void main(String[] args) {
        //多态
        Animal a = new Cat();//向上转：父类引用指向子类对象
        a.eat();
//        a.play();
        /*//创建子类对象
        Cat c = new Cat();
        c.eat();
        c.play();*/

        //向下转型:父类引用转为子类对象
        Cat c = (Cat) a;//解决父类引用不能调用子类独有方法的问题
        c.play();
        c.eat();
    }
}
