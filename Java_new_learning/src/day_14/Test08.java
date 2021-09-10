package day_14;

import java.lang.reflect.Field;

public class Test08 {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("day_14.Student");
        //反射创建一个对象
        Student stu = (Student) clazz.getConstructor().newInstance();

        //访问公有属性
        Field f = clazz.getField("b");
        f.set(stu, "第一");//对属性设置值
        System.out.println((String) f.get(stu));

        //访问私有属性
        Field f1 = clazz.getDeclaredField("school");
        f1.setAccessible(true);//解除私有封装
        f1.set(stu, "ooo");
        System.out.println((String) f1.get(stu));
    }
}
