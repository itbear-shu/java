package day_6;

public class TestDemo {
    public static void swap(DataSwap ds1) {
        ds1.i = 1;
        System.out.println("在swap中，dis1.a的值是：" + ds1.i);
    }
    public static void main(String[] args) {
        DataSwap ds2 = new DataSwap();
        System.out.println("在Swap前，dis2.i的值是：" + ds2.i);
        swap(ds2);
        System.out.println("在Swap后，dis2.i的值是：" + ds2.i);
    }
}
