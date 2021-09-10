package day_8;
/*单例设计模式--懒汉式*/
public class Single1 {
    //私有化构造，外界不能直接new对象
    private Single1() {

    }

    private static Single1 s1 = null;
    //如果实例未创建，就先创建，在返回给调用者
    public static Single1 getInstance() {
        if(s1 == null) {
            s1 = new Single1();
        }
        return s1;
    }
}
