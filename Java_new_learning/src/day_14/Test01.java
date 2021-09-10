package day_14;

public class Test01 {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("day_14.Student");//获取Class实例

        Class superClazz = clazz.getSuperclass();//获取父类
        System.out.println(superClazz.getName());

        Class[] interfaces = clazz.getInterfaces();//获取接口，是一个数组
        for (Class c:interfaces) {
            System.out.println(c.getName());
        }
    }
}
