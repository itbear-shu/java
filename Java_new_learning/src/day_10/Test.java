package day_10;

public class Test {
    public static void main(String[] args) {
//        String[] strings = new String[]{"a","b","c"};
//        System.out.println(strings[3]);//ArrayIndexOutOfBoundsException数组越界异常
//        A a = null;
//        System.out.println(a.i);//NullPointerException
        try{//用try{}来括住可能出现异常的代码
            System.out.println(1/0);
        } catch (Exception e) {//当不知道什么类型的异常时，使用所有异常的父类exception
//            e.printStackTrace();//输出异常，且不中断代码
            e.getMessage();
        }

    }
}
class A{
    int i;
}