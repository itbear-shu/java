package day_5;

public class TestDemo {
    //    static int i = 0;
    public static void main(String[] args) {
//        System.out.println(i);//static方法只能访问类中的static修饰的变量

//        Person p = new Person("zjx", 19);
//        System.out.println(p.getAge());
//
//        Person2 p2 = new Person2();
//        p2.age = 19;
//        p2.name = "abc";
//        p2.gender = "male";
//
//        p2.study();
//        p2.showAge();
//        System.out.println(p2.addAge(2));
//
//        System.out.println(new Circle().Calculate(3));
//        TestDemo t = new TestDemo();
//        t.mOL(1);
//        t.mOL(1, 2);
//        t.mOL("啊吧啊吧");
//
//        t.max(19, 02);
//        t.max(19.9, 19.0);
//        t.max(19.1, 19.2, 19.3);
        Person3 p3 = new Person3();
        String[] str1 = new String[] {"zjx", "19"};
        p3.printInfo(str1);
        String[] str2 = new String[] {"shanghai", "xxx"};
        p3.printInfo1(str2);
    }

    public void mOL(int x) {
        System.out.println(x * x);
    }

    public void mOL(int x, int y) {
        System.out.println(x * y);
    }

    public void mOL(String str) {
        System.out.println(str);
    }

    public void max(int x, int y) {
        if (x > y) {
            System.out.println(x);
        } else {
            System.out.println(y);
        }
    }

    public void max(double x, double y) {
        if (x > y) {
            System.out.println(x);
        } else {
            System.out.println(y);
        }
    }

    public void max(double x, double y, double z) {
        double max = x;
        if (y > max) {
            max = y;
        } else if (z > max) {
            max = z;
        }
        System.out.println(max);
        System.out.println((x > y ? x : y) > z ? (x > y ? x : y):z);
    }


}
