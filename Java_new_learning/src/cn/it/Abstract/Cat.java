package cn.it.Abstract;

/**
 * @author jx
 * @date 2021/8/20
 **/
public class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("eat");
    }

    @Override
    public void move() {
        System.out.println("move");
    }

    public Cat() {
        super();
        System.out.println("Cat");
    }
}
