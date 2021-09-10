package day_1;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
//        long l = 10L;
//        float f = 10f;
//
//        int i = 10;
//        byte b = (byte) i;
//
//        short s = 5;
////        s = s - 5;
//        s = (short) (s - 5);
//
//        System.out.println(7.6 % 5);
//
//        int[] arr1 = new int[4];
//        int[] arr2 = new int[]{1, 2, 3};
//        int[] arr23 = {1, 2, 3};
//        int[] arr4 = new int[100];
//
//        String[] str = new String[]{"a", "b", "c"};
//        int[] arr = new int[4];
//        System.out.println(arr[1]);
//
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        System.out.println(a);
//
//        int[][] arr_2dim = new int[][]{
//                {1, 2},
//                {3, 2}
//        };
//        for (int i = 0; i < arr_2dim.length; i++) {
//            for (int j = 0; j < arr_2dim[i].length; j++) {
//                System.out.println(arr_2dim[i][j]);
//            }
//        }
//        int[] x,y[];

        int[] arr1 = new int[]{1, 2, 3};
        int[] arr2 = new int[3];
        int[] arr3 = {1, 2, 3};
        int arr4[] = {
                1, 2, 3, 4
        };

        int[][] arr11 = new int[][]{
                {1, 2},
                {3, 4}
        };
        int[][] arr22 = new int[2][2];
        int[][] arr33 = new int[2][];
        int[] arr44[] = new int[2][2];
        //二维数组遍历
        for (int i = 0; i < arr11.length; i++) {
            for (int j = 0; j < arr11[i].length; j++) {
                System.out.println(arr11[i][j]);
            }
        }

//        Test.age
        System.out.println(Test.age);
    }
}
