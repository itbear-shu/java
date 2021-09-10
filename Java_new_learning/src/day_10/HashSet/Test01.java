package day_10.HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test01 {
    public static void main(String[] args) {
        Set set = new HashSet();

        Set set1 = new HashSet();
        set1.add("a");
        set1.add("b");
        set1.add("c");

        set.add("a");
        set.add("b");
        set.add("c");

        System.out.println(set.equals(set1));

        //使用迭代器遍历集合
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //for each迭代集合
        for (Object obj: set) {
            System.out.println(obj);
        }
        //获取集合元素个数
        System.out.println(set.size());
        //判断是否为空
        System.out.println(set.isEmpty());

//        System.out.println("set: " + set.hashCode());
//        System.out.println("set1: " + set.hashCode());
    }
}
