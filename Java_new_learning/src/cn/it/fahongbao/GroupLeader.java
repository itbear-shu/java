package cn.it.fahongbao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author jx
 * @date 2021/8/20
 **/
public class GroupLeader extends User {
    public GroupLeader() {
    }

    public GroupLeader(String name, double money) {
        super(name, money);
    }

    // 普通红包为1，拼手气红包为2
    public ArrayList<Double> send(double totalMoney, int count, int flag) {
        ArrayList<Double> list = new ArrayList<Double>();
        double leftMoney = this.getMoney();
        if (leftMoney < totalMoney) {
            System.out.println(this.getName() + "余额不足!");
            return list;
        }
        this.setMoney(leftMoney - totalMoney);
        if (flag == 1) {
            double avg = totalMoney / count;
            for (int i = 0; i < count; i++) {
                list.add(avg);
            }
        } else if (flag == 2) {
            int fen = (int) (totalMoney * 100);
            double income = 0;
            for (int i = 0; i < count; i++) {
                int f = new Random().nextInt(fen);
                if(i < count - 1) {
                    income = 0.01 + f / 100.0;
                    list.add(income);
                } else if(i == count -1) {
                    if (fen > 0) {
                        list.add(fen / 100.0);
                    } else
                        list.add(0.01);
                }
                fen -= f;
            }
        }
        return list;
    }

}
