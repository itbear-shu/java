package day_10.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Test01 {
    public static void main(String[] args) {
        //创建Map
        Map<String, Integer> map = new HashMap<String, Integer>();
        //添加数据
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        System.out.println(map);
        //根据key取值
        System.out.println(map.get("a"));
        //根据key移除键值对
        map.remove("d");
        //Map集合的长度
        System.out.println(map.size());
        //判断Map集合是否包含指定的key
        System.out.println(map.containsKey("a"));
        //判断Map集合是否包含指定的value
        System.out.println(map.containsValue(10));
        //获取Map集合的key
        System.out.println(map.keySet());
        //获取Map集合的value
        System.out.println(map.values());
        //通过Map.keySet()遍历Map
        for (String s : map.keySet()
             ) {
            System.out.println(map.get(s));
        }
        //通过Map.entrySet()遍历
        Set<Map.Entry<String, Integer>> entrys = map.entrySet();
        for (Map.Entry<String, Integer> entry :entrys
             ) {
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }
    }
}
