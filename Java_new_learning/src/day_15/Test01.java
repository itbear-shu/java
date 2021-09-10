package day_15;

public class Test01 {
    public static void main(String[] args) {
        Thread t1 = new TestThread();
        t1.start();//启动线程,开始运行run方法中的代码
        System.out.println("-------------------");
        System.out.println("-------------------");
        System.out.println("-------------------");
    }
}
