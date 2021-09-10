package day_14.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/*多态代理类*/
public class ProxyDemo implements InvocationHandler {
    Object obj;//被代理的对象

    public ProxyDemo(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " 开始执行");

        Object result = method.invoke(obj, args);//执行指定代理对象的指定方法

        System.out.println(method.getName() + " 执行完毕");
        return result;
    }
}
