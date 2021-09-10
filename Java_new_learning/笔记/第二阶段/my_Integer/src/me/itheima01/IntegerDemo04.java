package me.itheima01;

import java.util.Arrays;
import java.util.Scanner;

public class IntegerDemo04 {
    public static void main(String[] args) {
        //定义一个String
        String s = "10 20 10 20 10";
        //分割成String数组
        String[] strArray = s.split(" ");
        //定义int数组
        int[] intArray = new int[strArray.length];
        //把String转换为int
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        //用Arrays.sort()排序
        Arrays.sort(intArray);
        //定义一个StringBuilder对象
        StringBuilder sb = new StringBuilder();
        sb.append("\"");
        for (int i = 0; i < strArray.length; i++) {
            if(i == strArray.length-1){
                sb.append(intArray[i]);
            } else {
                sb.append(intArray[i]).append(" ");
            }
        }
        sb.append("\"");
        System.out.println(sb.toString());
    }
}
