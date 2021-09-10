package cn.it.Abstract;

/**
 * @author jx
 * @date 2021/8/20
 **/
public abstract class Animal {
    public Animal() {
        System.out.println("Animal");
    }
    public abstract void eat();
    public abstract void move();
}
