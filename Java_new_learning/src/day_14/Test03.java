package day_14;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.lang.reflect.Constructor;

public class Test03 {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("day_14.Student");
        //相当于调用类的无参公有构造方法
        Object obj = clazz.newInstance();
        Student stu = (Student) obj;
        //相当于调用类的有一个参数（String类型）且公有构造方法
        Constructor c = clazz.getConstructor(String.class);
        Student stu1 = (Student) c.newInstance("abc");
        //通过反射机制，可以强制调用私有构造方法
        Constructor c1 = clazz.getDeclaredConstructor(int.class, String.class);

        c1.setAccessible(true);//解除私有封装

        Student stu2 = (Student) c1.newInstance(10, "aaa");
    }
}
