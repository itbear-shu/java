package com.it.annotation;

import java.lang.reflect.Method;

@Pro(className = "com.it.annotation.Demo1", methodName = "show")
public class ReflectTest {

    public static void main(String[] args) throws Exception{
        //1.解析注解
        //1.1获取该类的字节码文件
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        //2.获取上边的注解对象
        //其实就是在内存中生产了一个该注解接口的子类实现对象
        /*
         * public class ProImpl implement Pro {
         *   public String className() {
         *       return "com.it.annotation.Demo1";
         *   }
         *
         *   public String methodName() {
         *       return "show";
         *   }
         * }
         * */
        Pro an = reflectTestClass.getAnnotation(Pro.class);
        //3.调用注解对象中调用的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();

        System.out.println(className);
        System.out.println(methodName);

        Class<?> clazz = Class.forName(className);
        Object object = clazz.newInstance();
        Method method = clazz.getMethod(methodName);
        method.invoke(object);
    }
}


