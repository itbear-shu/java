package day_10.Map;

import java.util.Map;

public class TreeMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new java.util.TreeMap<Integer, String>();
        map.put(4, "a");
        map.put(3, "a");
        map.put(1, "a");
        map.put(2, "a");
        map.put(5, "a");
        System.out.println(map);
    }
}
