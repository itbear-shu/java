package day_15;

public class Test02 {
    public static void main(String[] args) {
        Runnable run = new TestRunnable();

        Thread t1 = new Thread(run);

        t1.start();

        Thread t2 = new Thread(run, "Thread-1");
        t2.start();
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
    }
}
