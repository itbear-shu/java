package me.itjx01;

public class CatOperator {
    //用类名作为形参
    public void useCat(Cat c, String name) {
        c.eat(name);
    }
    //用类名作为返回值
    public Cat getCat() {
        Cat c = new Cat();
        return c;
    }
}
