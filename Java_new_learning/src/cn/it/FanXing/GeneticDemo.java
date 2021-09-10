package cn.it.FanXing;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author jx
 * @date 2021/8/23
 **/
public class GeneticDemo {
    public static void main(String[] args) {
//        Generic<String> gc = new Generic<>();
//        gc.setE("ac");
//        GenericMethod gm = new GenericMethod();
//        gm.method01("abc");
//        GenericMethod.method02("a", "d", "m");
//        GenericInterfaceImpl<String> gi = new GenericInterfaceImpl<>();
//        String s = gi.test01("abc");
//        System.out.println(s);
//        gi.test02("abc");

    }
    public static void printArrayList(ArrayList<?> list) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
