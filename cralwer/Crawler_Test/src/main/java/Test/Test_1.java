package Test;

import java.util.ArrayList;
import java.util.List;

public class Test_1 {
    public static void main(String[] args) {
        List<String> strList = new ArrayList<>();
        strList.add("CSDN-ThinkWon");
        strList.add("简书-JourWon");
        strList.add("博客:https://blog.csdn.net/ThinkWon");

        strList.forEach(s -> System.out.println(s));
    }
}
