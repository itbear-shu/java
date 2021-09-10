package day_14;

import java.lang.reflect.Field;

public class Test06 {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("day_14.Student");

//        Field[] fs = clazz.getFields();
        Field[] fs = clazz.getDeclaredFields();
        for (Field f : fs
        ) {
            System.out.println("属性名：" + f.getName());
            System.out.println("修饰符：" + f.getModifiers());
            System.out.println("属性类型：" + f.getType());

            Package p = clazz.getPackage();
            System.out.println("属性所在的包：" + p.getName());
            System.out.println("-------------------------");
        }
    }
}
