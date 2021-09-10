package me.itjx01;

import java.util.ArrayList;
import java.util.Collection;

public class Collection01 {
    public static void main(String[] args) {
        //创建Collection对象
        Collection<String> c = new ArrayList<String>();
        //添加元素 boolean add()
        c.add("hello");
        c.add("world");
        c.add("world");
        System.out.println(c);

        //删除元素 boolean remove()
        c.remove("world");
        System.out.println(c);

        //清空集合 void clear()
        c.clear();
        System.out.println(c);

        c.add("world");
        //判断是否存在 boolean contains()
        System.out.println(c.contains("world"));

        //判断是否为空
        System.out.println(c.isEmpty());
    }
}
