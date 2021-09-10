package day_11;

import java.util.ArrayList;
import java.util.List;
//泛型:指定对象类型
public class Test {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<Integer>();
//
//        list.add(1);
//        list.add(2);
//
//        System.out.println(list);
        A<String> a = new A<>();
        a.setT("abc");
        a.showT();

        B<Integer> b = new B<Integer>();
        b.setT(1);
        b.showT();

        B<String> ab = new B<String>();
        ab.setT("gg");
        ab.showT();


        C<String> c = new C<>();
        c.out("A");
    }
}
/*泛型可以任取名
* 一般使用T,意为Type*/
class A<T> {
    private T t;//封装

    public A() {
    }

    public A(T t) {
        this.t = t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void showT() {
        System.out.println(this.t);
    }

}

class B<T> extends A<T>{//继承
    @Override
    public void showT() {
        System.out.println("这里时泛型时的多态");
    }
}

interface in<T> {
    void out(T t);
}

class C<T> extends A<T> implements in<T> {

    @Override
    public void out(T t) {
        System.out.println(t + "这里是接口多态");
    }
}


