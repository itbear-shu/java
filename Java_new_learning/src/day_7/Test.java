package day_7;

public class Test {//多态应用
    public void method(Person e) {
        e.showInfo();
    }
    public static void main(String[] args) {
        Test t = new Test();
        Student m = new Student();
        t.method(m);
    }
}
