package cn.it.fahongbao;

import java.util.ArrayList;

/**
 * @author jx
 * @date 2021/8/20
 **/
public class Demo {
    public static void main(String[] args) {
        GroupLeader leader = new GroupLeader("爆发户", 2000);
        leader.show();
        ArrayList<Double> list1 = leader.send(1000, 4, 1);
        for (Double dou1 : list1) {
            System.out.println(dou1);
        }
        leader.show();
        ArrayList<Double> list2 = leader.send(1000, 4, 2);
        for (Double dou2 : list2) {
            System.out.println(dou2);
        }
        leader.show();
//        NomalPartner partner1 = new NomalPartner("菜鸟1", 10);
//        partner1.receive(list);
//        partner1.show();
//        NomalPartner partner2 = new NomalPartner("菜鸟2", 10);
//        partner2.receive(list);
//        partner2.show();
//        NomalPartner partner3 = new NomalPartner("菜鸟3", 10);
//        partner3.receive(list);
//        partner3.show();
//        NomalPartner partner4 = new NomalPartner("菜鸟4", 10);
//        partner4.receive(list);
//        partner4.receive(list);
//        partner4.show();
//        NomalPartner partner5 = new NomalPartner("菜鸟5", 10);
//        partner5.receive(list);
//        partner5.receive(list);
//        partner5.show();
    }
}
