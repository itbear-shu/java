package cn.it.fahongbao;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author jx
 * @date 2021/8/20
 **/
public class NomalPartner extends User{
    private boolean flag = false;
    public NomalPartner() {
    }

    public NomalPartner(String name, double money) {
        super(name, money);
    }

    public void receive(ArrayList<Double> list) {
        if(flag) {
            System.out.println(this.getName()  + "已经抢过一次了！");
            return;
        }
        if(list.size() != 0) {
            this.setMoney(this.getMoney() + list.remove(new Random().nextInt(list.size())));
            flag = true;
        } else {
            System.out.println("红包已经抢光了！ " + this.getName() + "没有抢到红包！");
        }
    }
}
