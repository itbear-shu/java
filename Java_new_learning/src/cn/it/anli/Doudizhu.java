package cn.it.anli;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author jx
 * @date 2021/8/23
 **/
public class Doudizhu {
    public static void main(String[] args) {
        //花色
        ArrayList<String> huase = new ArrayList<>();
        huase.add("♥");
        huase.add("♠");
        huase.add("♣");
        huase.add("♦");
        //数字
        ArrayList<String> shuzi = new ArrayList<>();
        shuzi.add("2");
        shuzi.add("A");
        shuzi.add("K");
        shuzi.add("Q");
        shuzi.add("J");
        shuzi.add("10");
        shuzi.add("9");
        shuzi.add("8");
        shuzi.add("7");
        shuzi.add("6");
        shuzi.add("5");
        shuzi.add("4");
        shuzi.add("3");
        //牌面
        ArrayList<String> paimian = new ArrayList<>();
        //组装牌面
        for (String h : huase) {
            for (String d : shuzi) {
                paimian.add(h + d);
            }
        }
        paimian.add("大王");
        paimian.add("小王");
        //三个人的牌面
        ArrayList<String> p1 = new ArrayList<>();
        ArrayList<String> p2 = new ArrayList<>();
        ArrayList<String> p3 = new ArrayList<>();
        //底牌
        ArrayList<String> dp = new ArrayList<>();
        //打乱牌面
        Collections.shuffle(paimian);
        for (int i = 0; i < paimian.size(); i++) {
            if(i >= 51) {
                dp.add(paimian.get(i));
                continue;
            }
            if (i % 3 == 0) {
                p1.add(paimian.get(i));
            } else if (i % 3 == 1) {
                p2.add(paimian.get(i));
            } else if (i % 3 == 2) {
                p3.add(paimian.get(i));
            }
        }

        System.out.println("p1" + printArrList(p1));
        System.out.println("p2" + printArrList(p2));
        System.out.println("p3" + printArrList(p3));
        System.out.println("dp" + printArrList(dp));

    }

    public static String printArrList(ArrayList<String> list) {
        String p = "{";
        for (int i = 0; i < list.size(); i++) {
            if(i < list.size() - 1) {
                p += list.get(i) + ", ";
            } else {
                p += list.get(i) + "}";
            }
        }
        return p;
    }
}
