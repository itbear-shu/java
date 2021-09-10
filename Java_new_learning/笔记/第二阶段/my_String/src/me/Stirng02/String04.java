package me.Stirng02;

public class String04 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        String line = arrtoString(arr);
        System.out.println(line);
    }

    public static String arrtoString(int[] arr){
        String s = "";
        s += "[";
        for(int i = 0;i < arr.length;i++){
            if(i == arr.length - 1){
                s += arr[i];
            } else {
                s += arr[i];
                s += ", ";
            }
        }
        s += "]";
        return s;
    }
}
