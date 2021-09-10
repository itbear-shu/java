package com.it.test;

import com.it.juint.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /*
    * 初始化方法：用于资源申请，所有测试方法在执行前都会先执行
    * */
    @Before
    public void init() {
        System.out.println("init...");
    }

    /*
    * 释放资源的方法：在所有测试方法执行完毕后，都会自动执行
    * */
    @After
    public void close() {
        System.out.println("close...");
    }

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        int add_result = calculator.add(1, 2);
        System.out.println(add_result);

        Assert.assertEquals(3, add_result);
    }
}
