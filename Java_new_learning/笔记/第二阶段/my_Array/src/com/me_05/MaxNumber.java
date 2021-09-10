package com.me_05;

import java.util.Arrays;

public class MaxNumber {
    public static void main(String[] args) {
        int[] arr = {12, 45, 98, 73, 60};
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max)
                max = arr[i];
        }
        System.out.println("max: " + Arrays.stream(arr).max());
        System.out.println("min: " + Arrays.stream(arr).min());
    }
}
