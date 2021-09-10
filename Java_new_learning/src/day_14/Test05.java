package day_14;

import java.lang.reflect.Method;

public class Test05 {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("day_14.Student");
        //获取所有的公有私有方法
        Method[] ms = clazz.getDeclaredMethods();

        for (Method m: ms
             ) {
            System.out.println("方法名：" + m.getName());
            System.out.println("返回值类型" + m.getReturnType());
            System.out.println("修饰符：" + m.getModifiers());

            Class[] cs = m.getParameterTypes();
            for (Class c:cs
                 ) {
                System.out.println("参数名称：" + c.getName());
            }

            System.out.println("---------------------");
        }
    }
}
