package day_9;

public class Person {
    private String name;
    private static int age = 1;

    public Person() {
        this.name = "jj";
        System.out.println("执行构造方法");
    }
    //非静态代码块
    {
        System.out.println("执行非静态代码块1");
    }
    {
        System.out.println("执行非静态代码块2");
    }
    {
        System.out.println("执行非静态代码块3");
    }

    //静态代码块
    static {
        //只能使用静态(static)修饰的属性和方法
        System.out.println(age);
    }
}
