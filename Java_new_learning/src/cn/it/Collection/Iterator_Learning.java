package cn.it.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author jx
 * @date 2021/8/21
 **/
public class Iterator_Learning {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Iterator<String> iterator1 = list.iterator();iterator1.hasNext();) {
            System.out.println(iterator1.next());
        }
    }
}
