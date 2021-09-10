package day_8;

public class Chinese {
    static String country;//类变量（静态变量），不用实例化，直接类名.属性就可以使用，是类的一部分，被所有这个类的实例化对象共享
    String name;
    int age;//实力变量，只有实例化之后才能使用，属于实例化对象的一部分，不可共享

    public static void main(String[] args) {
        Chinese c = new Chinese();
        Chinese.country = "China";
        Chinese.country = "America";
    }
}
