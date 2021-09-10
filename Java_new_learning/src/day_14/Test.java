package day_14;

public class Test {
    public static void main(String[] args) {
        Person p = new Person();
        Class clazz = p.getClass();//clazz对象中包含对象p所属的Person类的所有信息

        //实例化Class类对象的三种方法
        //通过类名.class创建指定类的Class实例
        Class c1 = Person.class;
        //通过一个类的实例对象的getClass()方法，获取对应实例对象的类的Class实例
        Class c2 = p.getClass();
        //通过Class的静态方法forName(String className)来获取一个类的Class实例
        //className是指你要获取的class实例的类的全路径(包名.类名)
        try {
            Class c3 = Class.forName("day_14.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
