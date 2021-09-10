package com.it.annotation;

/**
* 注解演示javadoc
*
* @author zjx
* @version 1.0
* @since 1.5
* */
@SuppressWarnings("all")
@MyAnno2
public class AnnoDemo {
    /**
     * 计算两数之和
     * @param a 整数
     * @param b 整数
     * @return 两数的和
     * */

    @MyAnno(show = "a", strs = {"abc", "cde"})
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public String toString() {
        return "AnnoDemo{}";
    }

    @Deprecated
    public void show1() {

    }
}
