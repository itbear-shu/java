package com.method_change;

import java.util.Arrays;

public class Method_Max {
    public static void main(String[] args) {
        int[] arr = {22, 11, 34, 1324, 100};
        int max = get_Max(arr);
        System.out.println(max);
        System.out.println(Arrays.stream(arr).max());
    }
    public static int get_Max(int[] arr){
        int max = arr[0];
        for(int i = 0;i < arr.length;i++){
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}
