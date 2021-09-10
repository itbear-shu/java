package day_14;

import java.lang.reflect.Method;

public class Test04 {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("day_14.Student");
        //获取类的所有公有(public)方法
        Method[] ms = clazz.getMethods();

        for (Method m:ms
             ) {
            System.out.println("方法名：" + m.getName());
            System.out.println("返回值类型：" + m.getReturnType());
            System.out.println("修饰符：" + m.getModifiers());

            Class[] pcs = m.getParameterTypes();
            if(pcs != null && pcs.length > 0) {
                for (Class c:pcs
                     ) {
                    System.out.println("参数类型：" + c.getName());
                }
            }

            System.out.println("-------------------------------");
        }
    }
}
