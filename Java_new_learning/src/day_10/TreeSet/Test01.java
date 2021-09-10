package day_10.TreeSet;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test01 {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<Integer>();
        //TreeSet自然排序
        set.add(1);
        set.remove(1);
        set.contains(1);
        set.clear();
        set.isEmpty();
        //迭代器
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for (Integer i :set
        ) {
            System.out.println(i);
        }

        System.out.println(set);
    }
}
