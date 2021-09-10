package day_14;

import java.lang.reflect.Constructor;

public class Test02 {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("day_14.Student");

        Constructor[] c = clazz.getConstructors();//获取类的公有构造器，返回Constructors类型数组
        for (Constructor constructor:c
             ) {
//            System.out.println(constructor);//输出构造器，包括了修饰符、方法名、所有参数及其类型
//            System.out.println(constructor.getModifiers());//输出构造器的修饰符(1代表public, 2代表private)
//            System.out.println(constructor.getName());//输出构造器的方法名
/*
            Class[] paramClazz = constructor.getParameterTypes();//返回构造器的参数类型
            for (Class p:paramClazz
                 ) {
                System.out.println(p);
            }*/
        }

        Constructor[] c1 = clazz.getDeclaredConstructors();//获取类的所有构造器，返回Constructors类型数组
        for (Constructor constructor:c1
        ) {
//            System.out.println(constructor);//输出构造器，包括了修饰符、方法名、所有参数及其类型
//            System.out.println(constructor.getModifiers());//输出构造器的修饰符(1代表public, 2代表private)
            System.out.println(constructor.getName());//输出构造器的方法名

            Class[] paramClazz = constructor.getParameterTypes();//返回构造器的参数类型
            for (Class p:paramClazz
            ) {
                System.out.println(p);
            }
        }







    }
}
