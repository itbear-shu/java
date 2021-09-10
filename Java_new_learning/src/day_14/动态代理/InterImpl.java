package day_14.动态代理;

public class InterImpl implements Inter{
    @Override
    public void test1() {
        System.out.println("执行test1()方法");
    }

    @Override
    public void test2() {
        System.out.println("执行test2()方法");
    }
}
