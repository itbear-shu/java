package com.itheima;

import me.itcast.Fu;
import me.itcast.Teacher;

public class DemoTest {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.teach();
        Fu f = new Fu();
        f.show4();//不同包下无关的类只能访问public形式
    }
}
