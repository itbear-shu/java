package com.it.annotation.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 简单的测试框架
 * 当主方法执行后，会自动执行被检测的所有方法（加了check注解的方法）
 * 判断方法是否异常，记录到文件中
 */
public class TestCheck {
    public static void main(String[] args) throws Exception {
        //创建Calculator对象
        Calculator c = new Calculator();
        //获取字节码文件
        Class clazz = c.getClass();
        //获取所有的方法
        Method[] methods = clazz.getMethods();
        //记录出现异常的次数
        int number = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method method : methods) {
            //判断方法上是否有注解
            if(method.isAnnotationPresent(Check.class)) {
                //执行方法
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    //捕获异常，记录到文件中
                    number ++;
                    bw.write(method.getName() + "出现异常");
                    bw.newLine();
                    bw.write("异常名称是：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因：" + e.getMessage());
                    bw.newLine();
                    bw.write("------------------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次测试一共出现" + number + "次异常。");
        bw.flush();
        bw.close();
    }
}
