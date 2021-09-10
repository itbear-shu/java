package me.itjx01;

public class CatDemo {
    public static void main(String[] args) {
        Cat c = new Cat();
        CatOperator co = new CatOperator();
        co.useCat(c, "coffe");

        Cat c2 = co.getCat();
        c2.eat("加菲");
    }
}
