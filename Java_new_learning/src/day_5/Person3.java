package day_5;

public class Person3 {
    public void printInfo(String[] args) {
        for(int i = 0;i < args.length;i++) {
            System.out.println(args[i]);
        }
    }

    public void printInfo1(String... args) {
        for(int i = 0;i < args.length;i++) {
            System.out.println(args[i]);
        }
    }
}
