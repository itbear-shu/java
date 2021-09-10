package day_10.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
//        //创建元素
//        List<String> list1 = new ArrayList<String>();
//        List<String> list2 = new ArrayList<String>();
//        //添加元素
//        list1.add("a");
//        list1.add("c");
//        list1.add("d");
//        list1.add("b");
//        list1.add("g");
//        list1.add("d");
//
//        list2.add("1");
//        list2.add("2");
//        list2.add("3");
//        //在指定索引位置插入数据
//        list1.add(1, "a");
//        //在指定索引位置插入整个list
//        list1.addAll(1, list2);
//        //通过索引查看元素
//        System.out.println(list1.get(0));
//        //获取指定元素在集合中第一次出现的索引下标
//        System.out.println(list1.indexOf("d"));
//        //获取指定元素在集合中最后一次出现的索引下标
//        System.out.println(list1.lastIndexOf("d"));
//        //移除元素
//        list1.remove("a");
//        list1.remove(1);
//        //根据指定索引下标修改元素
//        list1.set(1, "aa");
//        //截取元素形成新的集合
//        List<String> subList = list1.subList(1, 4);
//        System.out.println(subList);

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
    }
}
