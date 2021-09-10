package day_5;
/*
* 人
* */
public class Person {
    //属性,成员变量，类的成员变量可以先声明，不用初始化，且有默认值
    private String name;//姓名，String默认值位null
    private int age;//年龄，int的默认值位0
    //实例化变量：再类实例化成对象之后才能使用

    public static String gender = "male";
    //类变量，static修饰，不需要类实例化成对象就可使用，直接通过类名调用

    //方法
    /*
    * 打印姓名*/
    public void showName() {
        System.out.println(name);
    }
    /*
    获取年龄
    * */
    public int getAge() {
        return age;
    }
    /*
    * 吃
    * food*/
    public void eat(String food) {
        System.out.println("eat " + food);
    }
    /*
    * 构造方法*/
    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
