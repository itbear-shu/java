package me.Exception01;

public class Exception01 {
    public static void main(String[] args) {
        System.out.println("begin");
        method();
        System.out.println("end");
    }

    public static void method() {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException a) {
            //System.out.println("索引出错！");
            System.out.println(a.getMessage());
            System.out.println(a.toString());
            a.printStackTrace();
        }
    }
}
