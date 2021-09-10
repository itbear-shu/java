package cn.it.Collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author jx
 * @date 2021/8/24
 **/
public class List_Learning {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        System.out.println(list.size());
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(1);
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for (Integer integer : set) {
            System.out.println(integer);
        }

    }
}
