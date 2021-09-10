package me.Interface06;

public class Demo {
    public static void main(String[] args) {
        BasketballTeacher bt = new BasketballTeacher("z", 29);
        PingpongTeacher pt = new PingpongTeacher("j", 30);
        BasketStudent bs = new BasketStudent("x", 18);
        PingpongStudent ps = new PingpongStudent("l", 12);

        bt.eat();
        bt.teach();

        pt.eat();
        pt.teach();
        pt.SpEng();

        bs.eat();
        bs.study();

        ps.eat();
        ps.study();
        ps.SpEng();
    }
}
