package day_10;

public class Test03 {
    public static void main(String[] args) throws Exception {
        //在main方法中抛出异常直接抛到虚拟机上去了，在程序中不能处理
        C c = new C();
//        try {//throws在代码处抛出的异常，在调用方法去捕获
//            c.test();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        c.test();
    }
}

class C{
    int i;//NullPointerException的父类时Exception
    public void test() throws NullPointerException, Exception {//可以使用throws在代码处抛出异常，在调用方法去捕获异常
        C c = null;
        System.out.println(c.i);
    }
    public void test0(int age) throws Exception {
        if(age >=0 && age <= 150){
            System.out.println("年龄：" + age);
        } else {
            throw new Exception("abab");
        }
    }
}

class D extends C{
    @Override
    public void test() throws Exception {//报错
        //
    }
}