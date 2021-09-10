package day_10.HashSet;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Set set = new HashSet();

        set.add(1);//添加元素
        set.add("a");

        set.remove(1);//移除元素

        System.out.println(set.contains("a"));//判断元素是否存在

        set.clear();//清空元素

        System.out.println(set);
    }
}
