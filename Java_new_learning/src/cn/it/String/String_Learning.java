package cn.it.String;

/**
 * @author jx
 * @date 2021/8/20
 **/
public class String_Learning {
    public static void main(String[] args) {
        String str1 = "abcdefg";
        String str2 = new String("abc");
        System.out.println(str1.equals(str2));
        String s1 = str1.substring(1);
        System.out.println(s1);
        System.out.println(str1.substring(1, 3));
        String replace = str1.replace("abc", "avc");
        System.out.println(replace);
        String str = "a,b,c,d";
        String[] strings1 = str.split(",");
        for (String s : strings1) {
            System.out.println(s);
        }
        String[] strings = str.split(",", 3);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
