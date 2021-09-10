package cn.it.CZxiang;

/**
 * @author jx
 * @date 2021/8/21
 * 拆箱和装箱
 **/
public class Demo {
    public static void main(String[] args) {
        Integer in1 = new Integer(1);
        Integer in2 = new Integer("1");
        Integer in3 = Integer.valueOf(1);
        Integer in4 = Integer.valueOf("1");
        int i = in4.intValue();

        Integer in5 = 1;
        int i5 = in5;

        String s = Integer.toString(1);
        String s1 = String.valueOf(1);
        String s2 = 1 + "";

        int i1 = Integer.parseInt("1");
    }
}
