package day_14.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Inter i = new InterImpl();
        /*
        * 如果想要一个对象通过Proxy.newProxyInstance方法被代理，
        * 那么这个类一定要有相应的接口
        * */
        i.test1();
        i.test2();
        System.out.println("--------------------------------");

        InvocationHandler handler = new ProxyDemo(i);
/*
* Proxy.newProxyInstance();
* 参数1是代理对象的类加载器，参数2是被代理对象的接口，参数3是代理对象
* 返回成功被代理后的对象
* */
        Inter t = (Inter) Proxy.newProxyInstance(handler.getClass().getClassLoader(), i.getClass().getInterfaces(), handler);
        t.test1();
        System.out.println("--------------------------------");
        t.test2();

    }
}
