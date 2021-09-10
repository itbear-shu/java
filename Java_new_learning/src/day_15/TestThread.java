package day_15;
/*继承Thread方式实现多线程*/
public class TestThread extends Thread{
    @Override
    public void run() {
        System.out.println("多线程运行的代码");
        for(int i = 0; i < 5;i++) {
            System.out.println("这是多线程的逻辑代码：" + i);
        }
    }
}
