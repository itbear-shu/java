package me.DuoTai04;

public class AnimalDemo {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.setAge(1);
        a.setName("加菲");
        System.out.println(a.getName() + ": " + a.getAge());
        a.eat();

        a = new Cat("加菲", 2);
        System.out.println(a.getName() + ": " + a.getAge());
        a.eat();

/*        Cat c = (Cat) a;
        c.eat();
        c.play();*/
    }
}
