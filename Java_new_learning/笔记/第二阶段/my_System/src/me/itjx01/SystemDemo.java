package me.itjx01;

public class SystemDemo {
    public static void main(String[] args) {
//        System.out.println("1");
////        System.exit(0);
//        System.out.println("2");
//
//        System.out.println(System.currentTimeMillis());
//        System.out.println(System.currentTimeMillis() / 1000 / 3600 / 24 / 365 + 1970 + "year");
//
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("共耗时: " + (end - start) + "毫秒");
    }
}
