package day_14;

import java.lang.reflect.Method;

public class Test07 {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("day_14.Student");
        Object obj = clazz.getConstructor().newInstance();
//        //得到名称是test,参数类型为String的方法,调用公有方法
//        Method m = clazz.getMethod("test", String.class);
//        m.invoke(obj, "在进行");//obj是需要实例化的对象，后面的参数是调用的方法所需的参数
//
//        //调用私有方法
//        Method m1 = clazz.getDeclaredMethod("test1", int.class);
//        m.setAccessible(true);//接触私有方法封装
//        m1.invoke(obj, 1);

        //调用有返回值的方法
        Method m2 = clazz.getMethod("getSchool");//没有参数，不填
        String str = (String) m2.invoke(obj);
        System.out.println(str);

    }
}
