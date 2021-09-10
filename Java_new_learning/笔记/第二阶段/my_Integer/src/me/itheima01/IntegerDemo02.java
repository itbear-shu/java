package me.itheima01;

public class IntegerDemo02 {
    public static void main(String[] args) {
        /*已过时
        Integer i1 = new Integer(10);
        System.out.println(i1);

        Integer i2 = new Integer("100");//只能是数字字符串
        System.out.println(i2);
         */
        Integer i1 = Integer.valueOf(100);
        System.out.println(i1);

        Integer i2 = Integer.valueOf("100");
        System.out.println(i2);

        /*Integer i3 = Integer.valueOf("abxc");//只能是数字字符串
        System.out.println(i3);*/
    }
}
