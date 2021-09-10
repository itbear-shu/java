package day_8;
/*单例设计模式--饿汉式*/
public class Single2 {
    //私有构造，构造方法私有化，调用类时不能直接使用new来创建对象
    private Single2() {

    }
    //私有的Single类型类变量,只创建一次
    private static Single2 single = new Single2();

    public static Single2 getInstance() {
        return single;
    }
}
