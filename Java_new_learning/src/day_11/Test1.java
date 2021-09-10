package day_11;

public class Test1 {
    public static void main(String[] args) {
        B1<String> b1 = new B1<String>();
        System.out.println(b1.test(new String()));

        B2 b2 = new B2();
        System.out.println(b2.test("a"));

    }
}

interface IB<T> {
    T test(T t);
}
/*未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明一起加入到类中*/
class B1<T> implements IB<T> {

    @Override
    public T test(T t) {
        return t;
    }
}

class B2 implements IB<String> {
//调用时不用指定泛型
    @Override
    public String test(String s) {
        return s + "指定泛型";
    }
}