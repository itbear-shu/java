package day_15;

public class Test03 {
    public static void main(String[] args) throws Exception {
        TestRun run1 = new TestRun();
        TestRun run2 = new TestRun();

//        Thread t1 = new Thread(run1, "t-1");
//        Thread t2 = new Thread(run2, "t-2");
        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);

//        t1.setPriority(10);
//        t2.setPriority(1);
        t1.start();
        t2.start();

//        System.out.println(t1.getName());
//        System.out.println(t2.getName());

        System.out.println("------------------------");
        System.out.println("------------------------");
//        t1.join();//相当于把t1的run代码插入到这个位置执行
//        //阻塞main方法，先执行t1.join()方法
        System.out.println("------------------------");
        System.out.println(t1.isAlive());

//        t1.setName("Thread-1");
//        System.out.println(t1.getName());
//        System.out.println(t2.getName());

        /*线程优先级就是哪个线程较大概率被优先执行
        * 优先级用数组1-10表示，数字越大优先级越高
        * 没有设置默认为5
        * */

//        System.out.println("t1线程优先级为：" + t1.getPriority());
//        System.out.println("t2线程优先级为：" + t2.getPriority());

    }
}

class TestRun implements Runnable{
    int count = 0;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " :Runnable多线程运行的代码");
        for(int i = 0; i < 5;i++) {
//            if(i % 2 != 0)
//            {
//                Thread.yield();//线程让步
//            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + " :这是Runnable多线程的逻辑代码：" + count);
        }
    }
}

