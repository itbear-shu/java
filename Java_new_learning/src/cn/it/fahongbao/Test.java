package cn.it.fahongbao;

import java.util.Random;

/**
 * @author jx
 * @date 2021/8/20
 **/
public class Test {
    public static void main(String[] args) {
        int count = 10;
        double totalMoney = 100;
        int j = 10;
        for (int i = 0; i < count; i++) {
            int k = new Random().nextInt(j);
            System.out.println(totalMoney * (k / 10.0));
            totalMoney *= (1 - k / 10.0);
            j -= k;
        }
    }
}
