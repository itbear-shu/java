package day_15;
/*
* 线程资源共享时存在问题
* 解决思路：一个线程整体执行完后，另一个线程再执行
* 添加synchronized关键字
* 普通方法加synchronized，锁的是整个对象，不是每一个方法
* 不同对象就是不同的锁，普通方法加synchronized，线程使用不同对象，还是有资源共享问题
* */
public class Test04 {
    public static void main(String[] args) {
        //定义账户对象
        Account account = new Account();
        Account account1 = new Account();
        //多线程对象
        User u_weixin = new User(account, 2000);
        User u_zhifubao = new User(account, 2000);

        Thread weixin = new Thread(u_weixin, "微信");
        Thread zhifubao = new Thread(u_zhifubao, "支付宝");

        weixin.start();
        zhifubao.start();
    }
}
class Account{
    public static double money = 3000;
    public synchronized void withdraw(double m) {//取钱
        String name = Thread.currentThread().getName();//线程名称
        if(money < m) {
            System.out.println(name + "操作:账户余额不足: " + money);
        } else {
            System.out.println(name + "操作:账户原有：" + money);
            System.out.println(name + "操作:取款金额：" + m);

            money -= m;
            System.out.println(name + "操作:剩余金额：" + money);
        }
    }
    public synchronized void withdraw1(double m) {//取钱
        String name = Thread.currentThread().getName();//线程名称
        if(money < m) {
            System.out.println(name + "操作:账户余额不足: " + money);
        } else {
            System.out.println(name + "操作:账户原有：" + money);
            System.out.println(name + "操作:取款金额：" + m);

            money -= m;
            System.out.println(name + "操作:剩余金额：" + money);
        }
    }
    //静态方法加同步锁synchronized，对于所有对象都是同一个锁
    public static synchronized void withdraw2(double m) {//取钱
        String name = Thread.currentThread().getName();//线程名称
        if(money < m) {
            System.out.println(name + "操作:账户余额不足: " + money);
        } else {
            System.out.println(name + "操作:账户原有：" + money);
            System.out.println(name + "操作:取款金额：" + m);

            money -= m;
            System.out.println(name + "操作:剩余金额：" + money);
        }
    }

    public void withdraw3(double m) {//取钱
        synchronized (this) {//表示当前对象代码块被加了同步锁
            String name = Thread.currentThread().getName();//线程名称
            if(money < m) {
                System.out.println(name + "操作:账户余额不足: " + money);
            } else {
                System.out.println(name + "操作:账户原有：" + money);
                System.out.println(name + "操作:取款金额：" + m);

                money -= m;
                System.out.println(name + "操作:剩余金额：" + money);
            }
        }
    }
}

class User implements Runnable{
    Account account;
    double money;

    public User(Account account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
//        if(Thread.currentThread().getName().equals("微信")) {
//            account.withdraw(money);
//        } else {
//            account.withdraw1(money);
//        }
//        account.withdraw2(money);
        account.withdraw3(money);
    }
}