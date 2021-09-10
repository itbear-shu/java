package cn.it.FanXing;

/**
 * @author jx
 * @date 2021/8/23
 **/
public class GenericMethod {
    public <E> void method01(E e) {
        System.out.println(e);
    }

    public static <E> void method02(E... es) {
        for (E e : es) {
            System.out.println(e);
        }
    }
}
