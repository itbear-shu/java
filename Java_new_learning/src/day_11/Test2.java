package day_11;
/*泛型方法*/
public class Test2 {
    public static void main(String[] args) {
        S<Object> s = new S<Object>();
        s.test2("a", "v", 1, 3, 1);
    }
}

class S<E> {
    private E e;
    //静态方法不能使用类定义的泛型
    public static void test3() {
//        System.out.println(e);
    }
    public <T> void test(T t) {
        System.out.println(t);
    }

    public <T> T test1(T t) {
        return t;
    }

    public <T> void test2(T... ts) {
        for (T t: ts
             ) {
            System.out.println(t);
        }
    }
}
