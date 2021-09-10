package me.iterator01;

import java.util.ArrayList;
import java.util.Collection;

public class Iterator {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<String>();
        c.add("java");
        c.add("hello");
        c.add("world");

        //Iterator<E> iterator(): 返回此集合中元素的迭代器，通过集合的iterator()得到
        java.util.Iterator<String> it = c.iterator();

        while (it.hasNext()) {
//            System.out.println(it.next());
            String next = it.next();
            System.out.println(next);
        }
    }
}
