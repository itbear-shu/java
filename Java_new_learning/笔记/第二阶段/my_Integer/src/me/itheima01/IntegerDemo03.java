package me.itheima01;

public class IntegerDemo03 {
    public static void main(String[] args) {
        //int----String
        int n1 = 10;
        //方式1
        String s1 = "" + n1;
        System.out.println(s1);

        //方式2
        String s2 = String.valueOf(n1);
        System.out.println(s2);

        //String--int
        //方式1：String--Integer-int
        String s3 = "100";
        Integer i1 = Integer.valueOf(s3);
        int ni1 = i1.intValue();
        System.out.println(ni1);
        //方式2
        System.out.println(Integer.parseInt(s3));


    }
}
